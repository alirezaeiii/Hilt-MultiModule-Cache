package com.android.sample.core.response

import com.android.sample.core.database.section.DbSection

class Section(
    val sectionId: String,
    val title: String,
    val description: String
)

fun Section.asDatabaseModel(): DbSection =
    DbSection(id = this.sectionId, title = this.title, description = this.description)