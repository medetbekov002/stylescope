package com.example.stylescope.presentation.ui.fragments.inter

import android.util.Log
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentInterBinding
import com.example.stylescope.presentation.model.login.LoginUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class InterFragment : BaseFragment<FragmentInterBinding, InterViewModel>(R.layout.fragment_inter) {
    override val binding: FragmentInterBinding by viewBinding(FragmentInterBinding::bind)
    override val viewModel: InterViewModel by viewModel()


    override fun constructListeners() {
        with(binding) {
            btnInter.setOnClickListener {
                viewModel.logIn(LoginUI(
                    username = edName.text.toString(),
                    password = etPassword.text.toString()
                ))
            }

            btnGo.setOnClickListener {
                findNavController().navigate(R.id.mainFragment)
            }

            tvRegister.setOnClickListener {
                findNavController().navigate(R.id.registerFragment)
            }
        }
    }

    override fun launchObservers() {
        super.launchObservers()
        with(binding){
            viewModel.state.spectateUiState(success = {answer ->
                Log.e("ololo","IF.lO.success:$answer")
                findNavController().navigate(R.id.successFragment)
            },
            error = {
                Log.e("ololo","BS.sUS.error:${it}")

            })
        }
    }
}