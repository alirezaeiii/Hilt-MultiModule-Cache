package com.android.sample.viaplay.feature.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.sample.common.base.BaseFragment
import com.android.sample.common.util.Resource
import com.android.sample.viaplay.feature.list.BR
import com.android.sample.viaplay.feature.list.databinding.FragmentMainBinding
import com.android.sample.viaplay.feature.list.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentMainBinding>() {

    override val viewModel by viewModels<DashboardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentMainBinding.inflate(inflater, container, false)
        applyDataBinding(binding, BR.vm)

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
            if (resource is Resource.Success) {
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