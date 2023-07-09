package com.example.stylescope.presentation.ui.fragments.profile.user_change_password

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.user.profile.UserChangePasswordUseCase
import com.example.stylescope.presentation.model.password.UserChangePasswordUI
import kotlinx.coroutines.flow.asStateFlow

class ChangeUserPasswordViewModel(
    private val userChangePasswordUseCase: UserChangePasswordUseCase
) : BaseViewModel() {

    private val _changeUserPasswordState = mutableUIStateFlow<List<String>>()
    val changeUserPasswordState get() = _changeUserPasswordState.asStateFlow()

    fun userChangePassword(model: UserChangePasswordUI) {
        userChangePasswordUseCase(model.toDomain()).gatherRequest(_changeUserPasswordState) { it }
    }
}