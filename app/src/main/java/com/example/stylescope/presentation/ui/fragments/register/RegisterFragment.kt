package com.example.stylescope.presentation.ui.fragments.register

import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentRegisterBinding
import com.example.stylescope.presentation.model.login.RegisterUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterViewModel>(R.layout.fragment_register) {
    override val binding: FragmentRegisterBinding by viewBinding(FragmentRegisterBinding::bind)
    override val viewModel: RegisterViewModel by viewModel()
    private val pref:Pref by lazy { Pref(requireContext()) }

    override fun constructListeners() {
        binding.btnRegister.setOnClickListener {
            doRequest()
        }

        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.interFragment)
        }
        binding.btnGo.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }

    override fun launchObservers() {
        super.launchObservers()
        with(binding) {

            viewModel.state.spectateUiState(
                success = {
                    pref.saveUsername(etName.text.toString())
                    pref.saveIsRecover(false)
                    pref.saveEmail(etEmail.text.toString())
                    findNavController().navigate(R.id.confirmCodeFragment)
                },
                error = {
                    etConfirmPassword.setEditTextBackground(R.drawable.bg_error_et)
                    etPassword.setEditTextBackground(R.drawable.bg_error_et)
                    etEmail.setEditTextBackground(R.drawable.bg_error_et)
                    etName.setEditTextBackground(R.drawable.bg_error_et)
                    tilConfirmPassword.helperText = ""
                    tilEmail.helperText = "Имя пользователя занято или почта неверна"
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )
        }
    }

    private fun doRequest() {
        with(binding) {
            boxStrokeInfo(R.drawable.urmat_bg_edit, "")
            boxStrokePassword(R.drawable.urmat_bg_edit, "")
            if (etName.text.toString().isEmpty() || etPassword.text.toString()
                    .isEmpty() || etConfirmPassword.text.toString()
                    .isEmpty() || etName.text.toString().isEmpty()
            ) {
                boxStrokeInfo(R.drawable.bg_error_et, "")
                boxStrokePassword(R.drawable.bg_error_et, "Заполните поля")
            } else if (etPassword.text.toString() != etConfirmPassword.text.toString()) {
                boxStrokePassword(R.drawable.bg_error_et, "Пароль не совпадает")
                boxStrokeInfo(R.drawable.urmat_bg_edit, "")
            } else if ((etConfirmPassword.text?.length ?: 0) < 8 || (etPassword.text?.length
                    ?: 0) < 8
            ) {
                boxStrokeInfo(R.drawable.urmat_bg_edit, "")
                boxStrokePassword(R.drawable.bg_error_et, "Минимальное количество символов 8")
            } else {
                viewModel.register(
                    RegisterUI(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        etConfirmPassword.text.toString()
                    )
                )
            }
        }

    }

    private fun EditText.setEditTextBackground(color: Int) {
        background = ContextCompat.getDrawable(requireContext(), color)
    }

    private fun boxStrokeInfo(color: Int, helperText: String) {
        binding.etEmail.setEditTextBackground(color)
        binding.etName.setEditTextBackground(color)
        binding.tilEmail.helperText = helperText
    }

    private fun boxStrokePassword(color: Int, helperText: String) {
        binding.etConfirmPassword.setEditTextBackground(color)
        binding.etPassword.setEditTextBackground(color)
        binding.tilConfirmPassword.helperText = helperText
    }

}