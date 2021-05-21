package com.android.sample.core.repository

import com.android.sample.common.base.BaseRepository
import com.android.sample.core.database.asDomainModel
import com.android.sample.core.database.dashboard.DashboardDao
import com.android.sample.core.network.ViaplayService
import com.android.sample.core.response.Dashboard
import com.android.sample.core.response.asDatabaseModel
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardRepository @Inject constructor(
    private val remoteDataSource: ViaplayService,
    private val dao: DashboardDao
) : BaseRepository<Dashboard>() {

    override fun getResultFromRemoteDataSource(url: String?): Observable<Dashboard> =
        remoteDataSource.getDashboard().flatMap {
            dao.insert(it.asDatabaseModel()).andThen(Observable.fromCallable { it })
        }

    override fun getResultFromLocalDataSource(id: String?): Dashboard? =
        dao.getDashboard()?.asDomainModel()
}