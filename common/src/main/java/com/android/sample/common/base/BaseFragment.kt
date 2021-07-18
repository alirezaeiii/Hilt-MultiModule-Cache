package com.android.sample.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VM: ViewModel, T: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
): Fragment() {

    protected abstract val viewModel: VM

    protected abstract val vmVariableId: Int

    protected lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.apply {
            setVariable(vmVariableId, viewModel)
            // Set the lifecycleOwner so DataBinding can observe LiveData
            lifecycleOwner = viewLifecycleOwner
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}