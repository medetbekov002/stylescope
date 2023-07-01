package com.example.stylescope.presentation.ui.fragments.register

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterViewModel>(R.layout.fragment_register) {
    override val binding: FragmentRegisterBinding by viewBinding(FragmentRegisterBinding::bind)
    override val viewModel: RegisterViewModel by viewModel()

    override fun constructListeners() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.confirmCodeFragment)
        }

        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.interFragment)
        }

        binding.btnGo.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
}