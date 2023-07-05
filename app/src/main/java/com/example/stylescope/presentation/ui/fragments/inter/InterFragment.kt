package com.example.stylescope.presentation.ui.fragments.inter

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
import com.example.stylescope.data.remote.module.provideRetrofit
import com.example.stylescope.databinding.FragmentInterBinding
import com.example.stylescope.presentation.model.login.LoginUI
import com.example.stylescope.presentation.model.token.RefreshTokenUI
import com.example.stylescope.presentation.ui.token.TokenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class InterFragment : BaseFragment<FragmentInterBinding, InterViewModel>(R.layout.fragment_inter) {
    override val binding: FragmentInterBinding by viewBinding(FragmentInterBinding::bind)
    override val viewModel: InterViewModel by viewModel()
    private val pref: Pref by lazy { Pref(requireContext()) }


    override fun constructListeners() {
        with(binding) {
            btnInter.setOnClickListener {
                doRequest()
            }

            btnGo.setOnClickListener {
                findNavController().navigate(R.id.mainFragment)
            }

            tvRegister.setOnClickListener {
                findNavController().navigate(R.id.registerFragment)
            }
            tvForgetPassword.setOnClickListener {
                findNavController().navigate(R.id.recoveryFragment)
            }
        }
    }

    override fun launchObservers() {
        super.launchObservers()
        with(binding) {
            viewModel.state.spectateUiState(
                success = {
                    pref.saveUsername(edName.text.toString())
                    pref.savePassword(etPassword.text.toString())
                    findNavController().navigate(R.id.successFragment)
                },
                error = {
                    edName.setEditTextBackground(R.drawable.bg_error_et)
                    etPassword.setEditTextBackground(R.drawable.bg_error_et)
                    etPasswordContainer.helperText = "Неверный пароль или имя пользователя"
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )
        }
    }

    private fun doRequest() {
        with(binding) {
            edName.setEditTextBackground(R.drawable.urmat_bg_edit)
            etPassword.setEditTextBackground(R.drawable.urmat_bg_edit)
            etPasswordContainer.helperText = ""
            if (edName.text.toString().isEmpty() || etPassword.text.toString().isEmpty()) {
                edName.setEditTextBackground(R.drawable.bg_error_et)
                etPassword.setEditTextBackground(R.drawable.bg_error_et)
                etPasswordContainer.helperText = "Заполните поля"
            } else {
                viewModel.logIn(
                    LoginUI(
                        username = edName.text.toString(),
                        password = etPassword.text.toString()
                    )
                )
            }
        }
    }

    private fun EditText.setEditTextBackground(color: Int) {
        background = ContextCompat.getDrawable(requireContext(), color)
    }

}