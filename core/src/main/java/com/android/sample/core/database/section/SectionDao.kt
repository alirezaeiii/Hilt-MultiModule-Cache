package com.android.sample.core.database.section

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable

@Dao
interface SectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: DbSection): Completable

    @Query("SELECT * FROM sections WHERE id=:id")
    fun getSection(id: String): DbSection?
}