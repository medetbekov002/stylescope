package com.example.stylescope.domain.model.login

data class RegisterModel(
    val username: String,
    val email: String,
    val password: String,
    val password2: String
)

data class ResendConfirmCodeModel(
    val username: String
)
