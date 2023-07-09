package com.example.stylescope.domain.model.password

data class ChangePasswordModel(
    val oldPassword: String,
    val newPassword: String,
    val newPassword2: String
)

data class ResendResetCodeModel(
    val email: String
)
