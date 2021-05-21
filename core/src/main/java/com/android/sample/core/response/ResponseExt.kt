package com.android.sample.core.response

import com.android.sample.core.database.dashboard.DbDashboard
import com.android.sample.core.database.dashboard.DbLink
import com.android.sample.core.database.section.DbSection

fun Dashboard.asDatabaseModel(): DbDashboard {
    return DbDashboard(
        sections = this.links.sections.map {
            DbLink(id = it.id, title = it.title, href = it.href)
        }
    )
}

fun Section.asDatabaseModel(): DbSection =
    DbSection(id = this.sectionId, title = this.title, description = this.description)