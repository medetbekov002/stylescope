package com.example.stylescope.presentation.ui.fragments.changepassword

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.changepassword.ChangePasswordUseCase
import com.example.stylescope.presentation.model.changepassword.ChangePasswordAnswerUI
import com.example.stylescope.presentation.model.changepassword.ChangePasswordUI
import com.example.stylescope.presentation.model.changepassword.toChangePasswordAnswerUI
import com.example.stylescope.presentation.model.changepassword.toChangePasswordModel
import kotlinx.coroutines.flow.asStateFlow

class ChangePasswordViewModel(private val changePasswordUseCase: ChangePasswordUseCase):BaseViewModel() {

    private val _state = mutableUIStateFlow<ChangePasswordAnswerUI>()
    val state = _state.asStateFlow()

    fun changePassword(body:ChangePasswordUI){
        changePasswordUseCase(body.toChangePasswordModel()).gatherRequest(_state){it.toChangePasswordAnswerUI()}
    }


}