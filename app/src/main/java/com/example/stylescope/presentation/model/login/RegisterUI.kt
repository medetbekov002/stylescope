package com.example.stylescope.presentation.model.login

data class RegisterUI(
    val image: String,
    val username: String,
    val email: String,
    val password: String,
    val password2: String
)

data class ResendConfirmCodeUI(
    val username: String
)
