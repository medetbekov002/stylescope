package com.example.stylescope.domain.repository.confirm

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.confirm.ConfirmModel
import com.example.stylescope.domain.model.confirm.RecoverConfirmModel
import com.example.stylescope.domain.model.confirm.ResendConfirmModel
import com.example.stylescope.domain.model.recover.RecoverModel
import kotlinx.coroutines.flow.Flow

interface ConfirmRepository {

    fun confirm(code:ConfirmModel):Flow<Either<String,AnswerModel>>

    fun resendConfirm(userName:ResendConfirmModel):Flow<Either<String,List<String>>>
    fun resendRecover(email:RecoverModel):Flow<Either<String,List<String>>>

}