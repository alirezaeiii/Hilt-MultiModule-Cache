package com.android.sample.app.feature.list.viewmodel

import com.android.sample.common.base.BaseRepository
import com.android.sample.common.base.BaseViewModel
import com.android.sample.common.util.schedulers.BaseSchedulerProvider
import com.android.sample.core.response.Dashboard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    repository: BaseRepository<Dashboard>,
    schedulerProvider: BaseSchedulerProvider,
) : BaseViewModel<Dashboard>(repository, schedulerProvider)