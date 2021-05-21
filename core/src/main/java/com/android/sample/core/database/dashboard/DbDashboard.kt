package com.android.sample.core.database.dashboard

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dashboard")
class DbDashboard(
    @PrimaryKey val primaryKey: String = "dashboard",
    val sections: List<DbLink>
)

