package com.example.stylescope.presentation.ui.fragments.about_us

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.stylescope.databinding.FragmentAboutUsBinding


class AboutUsFragment :
    BaseFragment<FragmentAboutUsBinding, AboutUsViewModel>(R.layout.fragment_about_us) {
    override val viewModel: AboutUsViewModel by viewModel()
    override val binding: FragmentAboutUsBinding by viewBinding(FragmentAboutUsBinding::bind)


}