package com.example.stylescope.presentation.ui.fragments.changepassword


import android.util.Log
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentChangePasswordBinding
import com.example.stylescope.presentation.model.changepassword.ChangePasswordUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangePasswordFragment :
    BaseFragment<FragmentChangePasswordBinding, ChangePasswordViewModel>(R.layout.fragment_change_password) {
    override val binding: FragmentChangePasswordBinding by viewBinding(FragmentChangePasswordBinding::bind)
    override val viewModel: ChangePasswordViewModel by viewModel()
    private val pref: Pref by lazy { Pref(requireContext()) }

    override fun launchObservers() {
        super.launchObservers()
        with(binding) {
            btnInter.setOnClickListener {
                doRequest()
            }
        }
    }

    private fun doRequest() {
        with(binding) {
            edNewPassword.setEditTextBackground(R.drawable.urmat_bg_edit)
            etConfirmPassword.setEditTextBackground(R.drawable.urmat_bg_edit)
            etConfirmPasswordContainer.helperText = ""
            if (edNewPassword.text.toString().isEmpty() || etConfirmPassword.text.toString()
                    .isEmpty()
            ) {
                etConfirmPassword.setEditTextBackground(R.drawable.bg_error_et)
                edNewPassword.setEditTextBackground(R.drawable.bg_error_et)
                etConfirmPasswordContainer.helperText = "Заполните поля"
            } else if (edNewPassword.text.toString() != etConfirmPassword.text.toString()) {
                etConfirmPassword.setEditTextBackground(R.drawable.bg_error_et)
                edNewPassword.setEditTextBackground(R.drawable.bg_error_et)
                etConfirmPasswordContainer.helperText = "Пароль не совпадает"
            } else {
                viewModel.changePassword(
                    ChangePasswordUI(
                        pref.showConfirmCode().toString(),
                        edNewPassword.text.toString(),
                        etConfirmPassword.text.toString()
                    )
                )
            }
        }
    }

    override fun constructListeners() {
        super.constructListeners()
        with(binding) {
            viewModel.state.spectateUiState(
                success = {
                    findNavController().navigate(R.id.interFragment)
                },
                error = {
                    Log.e("ololo", "CPF.cL.error$it")
                    etConfirmPasswordContainer.helperText = "Не верный код подьверждения"
                },
                gatherIfSucceed = { loading.progressBar.isVisible = it is UIState.Loading }

            )
        }
    }

    private fun EditText.setEditTextBackground(color: Int) {
        background = ContextCompat.getDrawable(requireContext(), color)
    }


}