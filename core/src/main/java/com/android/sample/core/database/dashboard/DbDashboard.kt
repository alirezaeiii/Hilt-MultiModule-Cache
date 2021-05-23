package com.android.sample.core.database.dashboard

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.sample.core.response.Dashboard
import com.android.sample.core.response.Link
import com.android.sample.core.response.Links


@Entity(tableName = "dashboard")
class DbDashboard(
    @PrimaryKey val primaryKey: String = "dashboard",
    val sections: List<DbLink>
)

fun DbDashboard.asDomainModel(): Dashboard {
    return Dashboard(
        links = Links(sections = this.sections.map {
            Link(id = it.id, title = it.title, href = it.href)
        })
    )
}

