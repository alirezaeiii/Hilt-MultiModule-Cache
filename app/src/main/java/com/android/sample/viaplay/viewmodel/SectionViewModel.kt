package com.android.sample.viaplay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.sample.common.base.BaseRepository
import com.android.sample.common.base.BaseViewModel
import com.android.sample.common.extension.cleanHref
import com.android.sample.common.util.schedulers.BaseSchedulerProvider
import com.android.sample.core.response.Link
import com.android.sample.core.response.Section
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SectionViewModel @AssistedInject constructor(
    repository: BaseRepository<Section>,
    schedulerProvider: BaseSchedulerProvider,
    @Assisted link: Link
) : BaseViewModel<Section>(repository, schedulerProvider, link.href.cleanHref(), link.id) {

    @AssistedFactory
    interface SectionViewModelFactory {
        fun create(link: Link): SectionViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: SectionViewModelFactory,
            link: Link
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(link) as T
            }
        }
    }
}