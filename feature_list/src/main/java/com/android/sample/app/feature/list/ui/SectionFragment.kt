package com.android.sample.app.feature.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.sample.common.base.BaseFragment
import com.android.sample.common.util.Resource
import com.android.sample.app.feature.list.BR
import com.android.sample.app.feature.list.R
import com.android.sample.app.feature.list.databinding.FragmentSectionBinding
import com.android.sample.app.feature.list.viewmodel.SectionViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SectionFragment : BaseFragment<SectionViewModel, FragmentSectionBinding>(
    R.layout.fragment_section
) {

    override val vmVariableId = BR.vm

    private val args: SectionFragmentArgs by navArgs()

    @Inject
    lateinit var sectionViewModelFactory: SectionViewModel.SectionViewModelFactory

    override val viewModel by viewModels<SectionViewModel> {
        SectionViewModel.provideFactory(sectionViewModelFactory, args.link)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        super.onCreateView(inflater, container, savedInstanceState)

        with(binding) {

            viewModel.liveData.observe(viewLifecycleOwner, { resource ->
                if (resource is Resource.Success) {
                    textTitle.text = resource.data?.title
                    textDescription.text = resource.data?.description
                }
            })

            toolbar.apply {
                setNavigationOnClickListener { findNavController().navigateUp() }
            }
        }

        return binding.root
    }
}