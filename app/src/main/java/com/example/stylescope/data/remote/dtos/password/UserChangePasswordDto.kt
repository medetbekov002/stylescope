package com.example.stylescope.data.remote.dtos.password

import com.example.stylescope.domain.model.password.UserChangePasswordModel
import com.google.gson.annotations.SerializedName

data class UserChangePasswordDto(
    @SerializedName("old_password")
    val oldPassword: String,
    @SerializedName("new_password")
    val newPassword: String,
    @SerializedName("new_password2")
    val newPassword2: String
)

//втысдфтыc;lkas
fun UserChangePasswordModel.toData() = UserChangePasswordDto(
    oldPassword = oldPassword,
    newPassword = newPassword,
    newPassword2 = newPassword2
)

data class ResendResetCodeDto(
    val email: String
)
