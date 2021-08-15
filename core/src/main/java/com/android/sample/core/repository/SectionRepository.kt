package com.android.sample.core.repository

import com.android.sample.common.base.BaseRepository
import com.android.sample.core.database.section.SectionDao
import com.android.sample.core.database.section.asDomainModel
import com.android.sample.core.network.ApiService
import com.android.sample.core.response.Section
import com.android.sample.core.response.asDatabaseModel
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SectionRepository @Inject constructor(
    private val remoteDataSource: ApiService,
    private val dao: SectionDao,
) : BaseRepository<Section>() {

    override fun getResultFromRemoteDataSource(url: String?): Observable<Section> =
        remoteDataSource.getSection(url!!).flatMap {
            dao.insert(it.asDatabaseModel()).andThen(Observable.fromCallable { it })
        }

    override fun getResultFromLocalDataSource(id: String?): Section? =
        dao.getSection(id!!)?.asDomainModel()
}