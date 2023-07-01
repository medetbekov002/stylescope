package com.example.stylescope.presentation.ui.fragments.confirm

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentConfirmCodeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConfirmCodeFragment :
    BaseFragment<FragmentConfirmCodeBinding, ConfirmCodeViewModel>(R.layout.fragment_confirm_code) {
    override val binding: FragmentConfirmCodeBinding by viewBinding(FragmentConfirmCodeBinding::bind)
    override val viewModel: ConfirmCodeViewModel by viewModel()


    override fun constructListeners() {
        binding.btnConfirm.setOnClickListener {
            findNavController().navigate(R.id.successFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}