package com.example.stylescope.presentation.ui.fragments.inter

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.data.remote.dtos.login.LoginAnswerDto
import com.example.stylescope.domain.use_cases.login.LogInUseCase
import com.example.stylescope.presentation.model.login.LogInAnswerUI
import com.example.stylescope.presentation.model.login.LoginUI
import com.example.stylescope.presentation.model.login.toLogInAnswerUI
import com.example.stylescope.presentation.model.login.toLogInModel
import kotlinx.coroutines.flow.asStateFlow

class InterViewModel(private val logInUseCase: LogInUseCase): BaseViewModel() {

    private val _state = mutableUIStateFlow<LogInAnswerUI>()
    val state = _state.asStateFlow()

    fun logIn(body:LoginUI){
        logInUseCase(body.toLogInModel()).gatherRequest(_state){it.toLogInAnswerUI()}
    }
}