package com.example.stylescope.domain.use_cases.login

import com.example.stylescope.domain.model.login.LoginModel
import com.example.stylescope.domain.repository.login.LogInRepository

class LogInUseCase(private val repository: LogInRepository) {

    operator fun invoke(body:LoginModel) = repository.logIn(body)

}