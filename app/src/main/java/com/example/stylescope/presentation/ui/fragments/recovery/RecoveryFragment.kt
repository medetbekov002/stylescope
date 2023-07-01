package com.example.stylescope.presentation.ui.fragments.recovery

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentRecoveryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecoveryFragment : BaseFragment<FragmentRecoveryBinding, RecoveryViewModel>(R.layout.fragment_recovery) {
    override val binding: FragmentRecoveryBinding by viewBinding(FragmentRecoveryBinding::bind)
    override val viewModel: RecoveryViewModel by viewModel()


}