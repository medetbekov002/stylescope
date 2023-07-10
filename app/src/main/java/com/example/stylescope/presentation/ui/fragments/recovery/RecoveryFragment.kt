package com.example.stylescope.presentation.ui.fragments.recovery

import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentRecoveryBinding
import com.example.stylescope.presentation.model.recover.RecoverUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecoveryFragment :
    BaseFragment<FragmentRecoveryBinding, RecoveryViewModel>(R.layout.fragment_recovery) {

    override val binding: FragmentRecoveryBinding by viewBinding(FragmentRecoveryBinding::bind)
    override val viewModel: RecoveryViewModel by viewModel()
    private val pref: Pref by lazy { Pref(requireContext()) }

    override fun constructListeners() {
        super.constructListeners()
        with(binding) {
            btnNext.setOnClickListener {
                doRequest()
            }
        }
    }

    override fun launchObservers() {
        super.launchObservers()
        with(binding) {
            viewModel.state.spectateUiState(
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                },
                success = {
                    pref.saveIsRecover(true)
                    pref.saveEmail(etName.text.toString())
                    findNavController().navigate(R.id.confirmCodeFragment)
                },
                error = {
                    etName.setEditTextBackground(R.drawable.bg_error_et)
                    tilName.helperText = "Неверный email"
                }
            )
        }
    }

    private fun doRequest() {
        with(binding) {
            etName.setEditTextBackground(R.drawable.urmat_bg_edit)
            tilName.helperText = ""
            if (etName.text.toString().isEmpty()) {
                etName.setEditTextBackground(R.drawable.bg_error_et)
                tilName.helperText = "Заполните поля"
            } else {
                viewModel.recover(
                    RecoverUI(etName.text.toString())
                )
            }
        }
    }

    private fun EditText.setEditTextBackground(color: Int) {
        background = ContextCompat.getDrawable(requireContext(), color)
    }
}