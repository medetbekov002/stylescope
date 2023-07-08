package com.example.stylescope.data.remote.dtos.password

import com.google.gson.annotations.SerializedName

data class ChangePasswordDto(
    @SerializedName("old_password")
    val oldPassword: String,
    @SerializedName("new_password")
    val newPassword: String,
    @SerializedName("new_password2")
    val newPassword2: String
)

data class ResendResetCodeDto(
    val email: String
)
