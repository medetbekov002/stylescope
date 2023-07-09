package com.example.stylescope.presentation.ui.fragments.profile.dialog

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.user.profile.UpdateUserImageUseCase
import com.example.stylescope.presentation.model.user.UpdateUserImageUI
import com.example.stylescope.presentation.model.user.toUI
import kotlinx.coroutines.flow.asStateFlow
import okhttp3.MultipartBody

class UpdateUserImageViewModel(private val updateUserImageUseCase: UpdateUserImageUseCase) :
    BaseViewModel() {

    private val _updateUserImageState = mutableUIStateFlow<UpdateUserImageUI>()
    val updateUserImageState get() = _updateUserImageState.asStateFlow()

    fun updateUserImage(image: MultipartBody.Part) {
        updateUserImageUseCase(image).gatherRequest(_updateUserImageState) { it.toUI() }
    }
}