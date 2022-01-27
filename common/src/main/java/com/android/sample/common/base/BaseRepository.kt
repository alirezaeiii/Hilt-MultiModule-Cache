package com.android.sample.common.base

import com.android.sample.common.util.NoDataException
import io.reactivex.Observable

abstract class BaseRepository<T> {

    private var cacheIsDirty = false

    protected abstract fun getResultFromRemoteDataSource(url: String?): Observable<T>

    protected abstract fun getResultFromLocalDataSource(id: String?): T?

    fun getResult(url: String?, id: String?): Observable<T> =
        Observable.fromCallable { cacheIsDirty }.flatMap {
            if (it) {
                getResultFromRemoteDataSource(url)
                    .doOnComplete { cacheIsDirty = false }
            } else {
                val resultFromLocalDataSource = getResultFromLocalDataSource(id)
                Observable.create { subscriber ->
                    if (resultFromLocalDataSource == null) {
                        subscriber.onError(NoDataException())
                    } else {
                        subscriber.onNext(resultFromLocalDataSource)
                    }
                }
            }.onErrorResumeNext(getResultFromRemoteDataSource(url)
                .doOnComplete { cacheIsDirty = false })
        }

    fun refresh() {
        cacheIsDirty = true
    }
}