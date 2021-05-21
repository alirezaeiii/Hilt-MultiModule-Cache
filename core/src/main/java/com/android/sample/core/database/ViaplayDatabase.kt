package com.android.sample.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.sample.core.BuildConfig
import com.android.sample.core.database.dashboard.DashboardDao
import com.android.sample.core.database.dashboard.DbDashboard
import com.android.sample.core.database.dashboard.DbLinkConverter
import com.android.sample.core.database.section.DbSection
import com.android.sample.core.database.section.SectionDao

@Database(
    entities = [DbDashboard::class, DbSection::class],
    version = BuildConfig.VIAPLAY_DATABASE_VERSION,
    exportSchema = BuildConfig.VIAPLAY_DATABASE_EXPORT_SCHEMA
)
@TypeConverters(DbLinkConverter::class)
abstract class ViaplayDatabase : RoomDatabase() {

    abstract fun dashboardDao(): DashboardDao

    abstract fun sectionDao(): SectionDao
}