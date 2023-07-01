package com.example.stylescope.data.remote.dtos.password

import com.google.gson.annotations.SerializedName

data class ResetPasswordDto(
    val email: String
)

data class ResetPasswordConfirmDto(
    val code: String,
    @SerializedName("new_password")
    val newPassword: String,
    @SerializedName("new_password2")
    val newPassword2: String
)
