package com.example.stylescope.domain.use_cases.confirm

import com.example.stylescope.domain.model.confirm.ConfirmModel
import com.example.stylescope.domain.model.confirm.ResendConfirmModel
import com.example.stylescope.domain.model.recover.RecoverModel
import com.example.stylescope.domain.repository.confirm.ConfirmRepository

class ConfirmUseCase(private val repository: ConfirmRepository) {

    fun confirm(code: ConfirmModel) = repository.confirm(code)
    fun resendRecover(email: RecoverModel) = repository.resendRecover(email)
    fun resendConfirm(userName: ResendConfirmModel) = repository.resendConfirm(userName)

}