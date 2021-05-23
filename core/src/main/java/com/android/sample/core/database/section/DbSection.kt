package com.android.sample.core.database.section

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.sample.core.response.Section

@Entity(tableName = "sections")
class DbSection(
    @PrimaryKey val id: String,
    val title: String,
    val description: String
)


fun DbSection.asDomainModel(): Section =
    Section(sectionId = this.id, title = this.title, description = this.description)