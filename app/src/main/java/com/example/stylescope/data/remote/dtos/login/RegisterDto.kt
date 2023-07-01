package com.example.stylescope.data.remote.dtos.login

data class RegisterDto(
    val image: String,
    val username: String,
    val email: String,
    val password: String,
    val password2: String
)

data class ResendConfirmCodeDto(
    val username: String
)
