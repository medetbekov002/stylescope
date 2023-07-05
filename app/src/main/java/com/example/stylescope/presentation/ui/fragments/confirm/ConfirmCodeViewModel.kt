package com.example.stylescope.presentation.ui.fragments.confirm

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.confirm.ConfirmUseCase
import com.example.stylescope.presentation.model.answers.AnswerUI
import com.example.stylescope.presentation.model.answers.toLogInAnswerUI
import com.example.stylescope.presentation.model.confirm.*
import com.example.stylescope.presentation.model.recover.RecoverUI
import com.example.stylescope.presentation.model.recover.toRecoverModel
import kotlinx.coroutines.flow.asStateFlow

class ConfirmCodeViewModel(private val confirmUseCase: ConfirmUseCase) : BaseViewModel() {

    private val _stateConfirm = mutableUIStateFlow<ConfirmAnswerUI>()
    val stateConfirm = _stateConfirm.asStateFlow()

    private val _stateResendConfirm = mutableUIStateFlow<List<String>>()
    val stateResendConfirm = _stateResendConfirm.asStateFlow()

    private val _stateResendRecover = mutableUIStateFlow<List<String>>()
    val stateResendRecover = _stateResendRecover.asStateFlow()

    fun confirm(code: ConfirmUI) {
        confirmUseCase.confirm(code.toConfirmModel()).gatherRequest(_stateConfirm) { it.toConfirmAnswerUI()}
    }

    fun resendConfirm(userName: ResendConfirmUI) {
        confirmUseCase.resendConfirm(userName.toResendConfirmModel())
            .gatherRequest(_stateResendConfirm) { it }
    }

    fun resendRecover(email: RecoverUI) {
        confirmUseCase.resendRecover(email.toRecoverModel())
            .gatherRequest(_stateResendRecover) { it }
    }

}