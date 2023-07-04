package com.example.stylescope.domain.use_cases.register

import com.example.stylescope.domain.model.login.RegisterModel
import com.example.stylescope.domain.repository.register.RegisterRepository

class RegisterUseCase(private val repository: RegisterRepository) {

    operator fun invoke(body:RegisterModel) = repository.register(body)
}