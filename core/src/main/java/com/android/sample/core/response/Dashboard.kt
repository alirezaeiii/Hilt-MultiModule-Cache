package com.android.sample.core.response

import com.android.sample.core.database.dashboard.DbDashboard
import com.android.sample.core.database.dashboard.DbLink
import com.squareup.moshi.Json

class Dashboard(
    @Json(name = "_links") val links: Links
)

fun Dashboard.asDatabaseModel(): DbDashboard {
    return DbDashboard(
        sections = this.links.sections.map {
            DbLink(id = it.id, title = it.title, href = it.href)
        }
    )
}