package com.android.sample.core.di

import com.android.sample.common.base.BaseRepository
import com.android.sample.core.repository.DashboardRepository
import com.android.sample.core.repository.SectionRepository
import com.android.sample.core.response.Dashboard
import com.android.sample.core.response.Section
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindDashboardRepository(dashboardRepository: DashboardRepository): BaseRepository<Dashboard>

    @Singleton
    @Binds
    internal abstract fun bindSectionRepository(sectionRepository: SectionRepository): BaseRepository<Section>
}