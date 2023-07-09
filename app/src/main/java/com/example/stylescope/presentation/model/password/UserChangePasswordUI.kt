package com.example.stylescope.presentation.model.password

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.password.UserChangePasswordModel

//sdjkbk;jsdn;wdjncl'
data class UserChangePasswordUI(
    val oldPassword: String,
    val newPassword: String,
    val newPassword2: String
): DataMapper<UserChangePasswordModel> {
    override fun toDomain() = UserChangePasswordModel(
        oldPassword = oldPassword,
        newPassword = newPassword,
        newPassword2 = newPassword2
    )
}

fun UserChangePasswordModel.toUI() = UserChangePasswordUI(
    oldPassword = oldPassword,
    newPassword = newPassword,
    newPassword2 = newPassword2
)

data class ResendResetCodeUI(
    val email: String
)
