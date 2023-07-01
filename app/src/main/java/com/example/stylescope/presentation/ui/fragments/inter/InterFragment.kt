package com.example.stylescope.presentation.ui.fragments.inter

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentInterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class InterFragment : BaseFragment<FragmentInterBinding, InterViewModel>(R.layout.fragment_inter) {
    override val binding: FragmentInterBinding by viewBinding(FragmentInterBinding::bind)
    override val viewModel: InterViewModel by viewModel()

    override fun constructListeners() {
        binding.btnInter.setOnClickListener {
            findNavController().navigate(R.id.successFragment)
        }

        binding.btnGo.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }

        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
    }
}