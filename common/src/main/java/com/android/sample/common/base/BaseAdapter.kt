package com.android.sample.common.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, R : RecyclerView.ViewHolder>
    (diffCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, R>(diffCallback)