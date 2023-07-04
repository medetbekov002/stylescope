package com.example.stylescope.presentation.model.confirm

import com.example.stylescope.domain.model.confirm.ConfirmModel
import com.example.stylescope.domain.model.confirm.RecoverConfirmModel
import com.example.stylescope.domain.model.confirm.ResendConfirmModel

data class ConfirmUI(
    val code: Int
)

data class ResendConfirmUI(
    val username: String
)

data class RecoverConfirmUI(
    val code: Int,
    val new_password: String,
    val new_password2: String
)

fun ConfirmUI.toConfirmModel() = ConfirmModel(code)
fun ResendConfirmUI.toResendConfirmModel() = ResendConfirmModel(username)
fun RecoverConfirmUI.toRecoverConfirmModel() = RecoverConfirmModel(code,new_password,new_password2)