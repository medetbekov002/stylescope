package com.example.stylescope.presentation.model.password


data class ResetPasswordUI(
    val email: String
)

data class ResetPasswordConfirmUI(
    val code: String,
    val newPassword: String,
    val newPassword2: String
)
