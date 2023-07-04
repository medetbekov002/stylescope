package com.example.stylescope.domain.repository.changepassword

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.changepassword.ChangePasswordAnswerModel
import com.example.stylescope.domain.model.changepassword.ChangePasswordModel
import kotlinx.coroutines.flow.Flow

interface ChangePasswordRepository {

    fun changePassword(body:ChangePasswordModel):Flow<Either<String, ChangePasswordAnswerModel>>

}