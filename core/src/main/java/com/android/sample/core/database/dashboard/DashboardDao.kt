package com.android.sample.core.database.dashboard

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable

@Dao
interface DashboardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: DbDashboard): Completable

    @Query("SELECT * FROM dashboard")
    fun getDashboard(): DbDashboard?
}