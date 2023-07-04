package com.example.stylescope.domain.model.confirm

data class ConfirmModel(
    val code: Int
)

data class ResendConfirmModel(
    val username: String
)

data class RecoverConfirmModel(
    val code: Int,
    val new_password: String,
    val new_password2: String
)

