package com.android.sample.core.database.section

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sections")
class DbSection(
    @PrimaryKey val id: String,
    val title: String,
    val description: String
)