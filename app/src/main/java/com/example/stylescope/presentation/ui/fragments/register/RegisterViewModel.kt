package com.example.stylescope.presentation.ui.fragments.register

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.register.RegisterUseCase
import com.example.stylescope.presentation.model.login.RegisterUI
import com.example.stylescope.presentation.model.login.toRegisterModel
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel(private val registerUseCase: RegisterUseCase): BaseViewModel() {

    private val _state = mutableUIStateFlow<List<String>>()
    val state = _state.asStateFlow()

    fun register(body:RegisterUI){
        registerUseCase(body.toRegisterModel()).gatherRequest(_state){it->
            it.map { it }
        }
    }


}