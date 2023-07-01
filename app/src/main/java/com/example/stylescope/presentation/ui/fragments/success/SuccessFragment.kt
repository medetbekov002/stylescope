package com.example.stylescope.presentation.ui.fragments.success

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentSuccessBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuccessFragment : BaseFragment<FragmentSuccessBinding, SuccessViewModel>(R.layout.fragment_success) {
    override val binding: FragmentSuccessBinding by viewBinding(FragmentSuccessBinding::bind)
    override val viewModel: SuccessViewModel by viewModel()

    override fun constructListeners() {
        binding.btnToMain.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
}