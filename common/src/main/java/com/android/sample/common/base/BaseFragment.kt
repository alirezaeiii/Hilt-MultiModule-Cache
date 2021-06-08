package com.android.sample.common.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<T: ViewDataBinding>: Fragment() {

    protected abstract val viewModel: ViewModel

    protected fun applyDataBinding(binding: T, variableId: Int) {
        binding.apply {
            setVariable(variableId, viewModel)
            // Set the lifecycleOwner so DataBinding can observe LiveData
            lifecycleOwner = viewLifecycleOwner
        }
    }
}