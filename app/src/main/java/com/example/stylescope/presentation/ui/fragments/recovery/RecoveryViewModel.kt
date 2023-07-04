package com.example.stylescope.presentation.ui.fragments.recovery

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.recover.RecoverUseCase
import com.example.stylescope.presentation.model.recover.RecoverUI
import com.example.stylescope.presentation.model.recover.toRecoverModel
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.map

class RecoveryViewModel(private val recoverUseCase: RecoverUseCase): BaseViewModel() {

    private val _state = mutableUIStateFlow<List<String>>()
    val state = _state.asStateFlow()

    fun recover(body:RecoverUI){
        recoverUseCase(body.toRecoverModel()).gatherRequest(_state){ it ->
            it.map { it.toString() }}
    }

}