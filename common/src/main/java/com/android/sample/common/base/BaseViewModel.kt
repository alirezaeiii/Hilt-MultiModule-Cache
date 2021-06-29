package com.android.sample.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.sample.common.util.Resource
import com.android.sample.common.util.schedulers.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * BaseViewModel designed to store and manage UI-related data in a lifecycle conscious way. This
 * allows data to survive configuration changes such as screen rotations. In addition, background
 * work such as fetching network results can continue through configuration changes and deliver
 * results after the new Fragment or Activity is available.
 */
open class BaseViewModel<T>(
    private val repository: BaseRepository<T>,
    private val schedulerProvider: BaseSchedulerProvider,
    private val linkUrl: String?,
    private val linkId: String?
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _liveData = MutableLiveData<Resource<T>>()
    val liveData: LiveData<Resource<T>>
        get() = _liveData

    fun loadItems(isRefreshing: Boolean) {
        if (isRefreshing) {
            repository.refresh()
        }
        _liveData.value = Resource.Loading
        repository.getResult(linkUrl, linkId).subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                _liveData.postValue(Resource.Success(it))
            }) {
                _liveData.postValue(Resource.Error(it.localizedMessage))
                Timber.e(it)
            }.also { compositeDisposable.add(it) }
    }

    /**
     * Called when the ViewModel is dismantled.
     * At this point, we want to cancel all disposables;
     * otherwise we end up with processes that have nowhere to return to
     * using memory and resources.
     */
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}