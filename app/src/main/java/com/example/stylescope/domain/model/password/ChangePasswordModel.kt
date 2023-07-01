package com.example.stylescope.domain.model.password

data class ChangePasswordModel(
    val oldPassword: String,
    val newPassword: String
)

data class ResendResetCodeModel(
    val email: String
)
