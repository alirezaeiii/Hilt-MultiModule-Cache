package com.android.sample.core.di

import android.content.Context
import androidx.room.Room
import com.android.sample.core.BuildConfig
import com.android.sample.core.database.ViaplayDatabase
import com.android.sample.core.database.dashboard.DbLinkConverter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideViaplayDatabase(context: Context, moshi: Moshi): ViaplayDatabase {
        DbLinkConverter.initialize(moshi)
        return Room.databaseBuilder(
            context,
            ViaplayDatabase::class.java,
            BuildConfig.VIAPLAY_DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideDashboardDao(db: ViaplayDatabase) = db.dashboardDao()

    @Singleton
    @Provides
    fun provideSectionDao(db: ViaplayDatabase) = db.sectionDao()
}