package com.example.stylescope.presentation.ui.fragments.confirm

import android.util.Log
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentConfirmCodeBinding
import com.example.stylescope.presentation.model.confirm.ConfirmUI
import com.example.stylescope.presentation.model.confirm.ResendConfirmUI
import com.example.stylescope.presentation.model.recover.RecoverUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConfirmCodeFragment :
    BaseFragment<FragmentConfirmCodeBinding, ConfirmCodeViewModel>(R.layout.fragment_confirm_code) {

    override val binding: FragmentConfirmCodeBinding by viewBinding(FragmentConfirmCodeBinding::bind)
    override val viewModel: ConfirmCodeViewModel by viewModel()
    private val pref: Pref by lazy { Pref(requireContext()) }

    override fun constructListeners() {
        with(binding) {
            btnConfirm.setOnClickListener {
                Log.e("ololo", "CCF.cL.bC:${pref.isRecover()},${pref.showUsername()}")
                if (pref.isRecover()) {
                    Log.e("ololo", "CCF.cL.bC.if:${pref.isRecover()},${pref.showUsername()}")
                    pref.saveConfirmCode(edCodeConfirm.enteredCode)
                    doRequest { findNavController().navigate(R.id.changePasswordFragment) }
                } else {
                    Log.e("ololo", "CCF.cL.bC.else:${pref.isRecover()},${pref.showUsername()}")
                    doRequest { viewModel.confirm(ConfirmUI(edCodeConfirm.enteredCode.toInt())) }
                }
            }
            tvRepeatCode.setOnClickListener {
                Log.e("ololo", "CCF.cL.tRC:${pref.isRecover()},${pref.showUsername()}")
                if (pref.isRecover()) {
                    Log.e("ololo", "CCF.cL.tRC.if:${pref.isRecover()},${pref.showEmail()}")
                    viewModel.resendRecover(RecoverUI(pref.showEmail().toString()))
                } else {
                    Log.e("ololo", "CCF.cL.tRC.else:${pref.isRecover()},${pref.showUsername()}")
                    viewModel.resendConfirm(
                        (ResendConfirmUI(pref.showUsername().toString()))
                    )
                }
            }

            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun doRequest(request: () -> Unit) {
        with(binding) {
            tvError.text = ""
            if (edCodeConfirm.enteredCode.length == 5) {
                request()
            } else {
                tvError.text = "Заполните все ячейки"
            }
        }
    }

    override fun launchObservers() {
        super.launchObservers()
        with(binding) {
            tvEmail.text = pref.showEmail()
            viewModel.stateConfirm.spectateUiState(
                success = {
                    findNavController().navigate(R.id.interFragment)
                },
                error = {
                    tvError.text = "Не верный код"
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )

            viewModel.stateResendConfirm.spectateUiState(
                error = {
                    tvError.text = "Не удалось отправить код"
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )
            viewModel.stateResendRecover.spectateUiState(
                error = {
                    tvError.text = it
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )

        }
    }

}