package com.example.stylescope.presentation.ui.fragments.profile.user_change_password

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentChangeUserPasswordBinding
import com.example.stylescope.presentation.model.password.UserChangePasswordUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangeUserPasswordFragment
    :
    BaseFragment<FragmentChangeUserPasswordBinding, ChangeUserPasswordViewModel>(R.layout.fragment_change_user_password) {
    override val binding: FragmentChangeUserPasswordBinding by viewBinding(FragmentChangeUserPasswordBinding::bind)
    override val viewModel: ChangeUserPasswordViewModel by viewModel()

    override fun launchObservers() {
        viewModel.changeUserPasswordState.spectateUiState(success = {
            Toast.makeText(requireContext(), "Пароль успешно изменен", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }, error = {
            Log.e("ololo", it)
        })

        binding.btnSaveNewPassword.setOnClickListener {
            val oldPassword = binding.etOldPassword.text.toString()
            val newPassword = binding.etNewPassword.text.toString()
            val confirmNewPassword = binding.etConfirmNewPassword.text.toString()
            viewModel.userChangePassword(
                UserChangePasswordUI(
                    oldPassword = oldPassword,
                    newPassword = newPassword,
                    newPassword2 = confirmNewPassword
                )
            )
        }
    }

}