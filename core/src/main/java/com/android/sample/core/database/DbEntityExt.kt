package com.android.sample.core.database

import com.android.sample.core.database.dashboard.DbDashboard
import com.android.sample.core.database.section.DbSection
import com.android.sample.core.response.Dashboard
import com.android.sample.core.response.Link
import com.android.sample.core.response.Links
import com.android.sample.core.response.Section

fun DbDashboard.asDomainModel(): Dashboard {
    return Dashboard(
        links = Links(sections = this.sections.map {
            Link(id = it.id, title = it.title, href = it.href)
        })
    )
}

fun DbSection.asDomainModel(): Section =
    Section(sectionId = this.id, title = this.title, description = this.description)