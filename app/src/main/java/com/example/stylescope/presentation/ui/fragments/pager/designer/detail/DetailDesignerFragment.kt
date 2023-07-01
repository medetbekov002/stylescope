package com.example.stylescope.presentation.ui.fragments.pager.designer.detail

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentDetailDesignerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailDesignerFragment : BaseFragment<FragmentDetailDesignerBinding, DetailDesignerViewModel>(
    R.layout.fragment_detail_designer) {
    override val binding: FragmentDetailDesignerBinding by viewBinding(FragmentDetailDesignerBinding::bind)
    override val viewModel: DetailDesignerViewModel by viewModel()

    override fun launchObservers() {


    }
}