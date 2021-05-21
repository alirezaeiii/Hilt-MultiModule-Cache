package com.android.sample.common.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.sample.common.base.BaseAdapter

@BindingAdapter("showData")
fun <T, R: RecyclerView.ViewHolder> RecyclerView.showData(resource: Resource<T>?) {
    if (resource is Resource.Error) {
        this.scrollToPosition(0)
        @Suppress("UNCHECKED_CAST")
        (this.adapter as BaseAdapter<T, R>).submitList(null)
    }
}

@BindingAdapter("refreshing")
fun <T> SwipeRefreshLayout.setSwipeRefreshLayout(resource: Resource<T>?) {
    isRefreshing = resource is Resource.Loading
}

@BindingAdapter("showData")
fun <T> View.showData(resource: Resource<T>?) {
    visibility = if (resource is Resource.Success) View.VISIBLE else View.GONE
}

@BindingAdapter("showError")
fun <T> View.showError(resource: Resource<T>?) {
    visibility = if (resource is Resource.Error) View.VISIBLE else View.GONE
}