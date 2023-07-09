package com.example.stylescope.presentation.ui.fragments.profile

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.user.profile.GetUserProfileUseCase
import com.example.stylescope.domain.use_cases.user.profile.UpdateUserProfileUseCase
import com.example.stylescope.presentation.model.user.UpdateUserProfileUI
import com.example.stylescope.presentation.model.user.UserValidateUI
import com.example.stylescope.presentation.model.user.toUI
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(
    private val userProfileUseCase: GetUserProfileUseCase,
private val updateUserProfileUseCase: UpdateUserProfileUseCase) : BaseViewModel() {

    private val _userProfileState = mutableUIStateFlow<UserValidateUI>()
    val userProfileState get() = _userProfileState.asStateFlow()

    private val _updateUserProfileState = mutableUIStateFlow<List<String>>()
    val updateUserProfileState get() = _updateUserProfileState.asStateFlow()
    fun getUserProfile() {
        userProfileUseCase().gatherRequest(_userProfileState) { it.toUI() }
    }

    fun updateUserProfile(model: UpdateUserProfileUI) {
        updateUserProfileUseCase(model = model.toDomain()).gatherRequest(_updateUserProfileState) {it}
    }
}