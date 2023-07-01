package com.example.stylescope.domain.repository.login

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.login.LogInAnswerModel
import com.example.stylescope.domain.model.login.LoginModel
import kotlinx.coroutines.flow.Flow

interface LogInRepository {

    fun logIn(body:LoginModel): Flow<Either<String,LogInAnswerModel>>

}