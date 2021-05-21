package com.android.sample.common.base

import com.android.sample.common.util.NoDataException
import io.reactivex.Observable

abstract class BaseRepository<T> {

    private var cacheIsDirty = false

    protected abstract fun getResultFromRemoteDataSource(url: String?): Observable<T>

    protected abstract fun getResultFromLocalDataSource(id: String?): T?

    private fun getRemoteResult(url: String?) = getResultFromRemoteDataSource(url)
        .doOnComplete { cacheIsDirty = false }

    fun getResult(url: String?, id: String?): Observable<T> =
        Observable.fromCallable { cacheIsDirty }.flatMap {
            if (it) {
                getRemoteResult(url)
            } else {
                Observable.create { subscriber ->
                    if (getResultFromLocalDataSource(id) == null) {
                        subscriber.onError(NoDataException())
                    } else {
                        subscriber.onNext(getResultFromLocalDataSource(id)!!)
                    }
                }
            }.onErrorResumeNext(getRemoteResult(url))
        }

    fun refresh() {
        cacheIsDirty = true
    }
}