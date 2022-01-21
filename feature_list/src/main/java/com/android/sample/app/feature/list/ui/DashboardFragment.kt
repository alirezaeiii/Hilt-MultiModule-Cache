package com.android.sample.app.feature.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.sample.common.base.BaseFragment
import com.android.sample.common.util.ViewState
import com.android.sample.app.feature.list.BR
import com.android.sample.app.feature.list.R
import com.android.sample.app.feature.list.databinding.FragmentDashboardBinding
import com.android.sample.app.feature.list.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<DashboardViewModel, FragmentDashboardBinding>(
    R.layout.fragment_dashboard, BR.vm
) {
    override val viewModel by viewModels<DashboardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        super.onCreateView(inflater, container, savedInstanceState)

        val viewModelAdapter =
            LinkAdapter(LinkAdapter.OnClickListener { link ->
                val destination =
                    DashboardFragmentDirections.actionDashboardFragmentToSectionFragment(link)
                with(findNavController()) {
                    currentDestination?.getAction(destination.actionId)
                        ?.let { navigate(destination) }
                }
            })

        viewModel.liveData.observe(viewLifecycleOwner, { resource ->
            if (resource is ViewState.Success) {
                viewModelAdapter.submitList(resource.data?.links?.sections)
            }
        })

        with(binding) {
            recyclerView.adapter = viewModelAdapter
            recyclerView.setHasFixedSize(true)
        }

        return binding.root
    }
}