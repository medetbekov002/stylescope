package com.example.stylescope.presentation.model.login

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.login.RegisterModel

data class RegisterUI(
    val username: String,
    val email: String,
    val password: String,
    val password2: String
): DataMapper<RegisterModel> {
    override fun toDomain() = RegisterModel(
        username = username,
        email = email,
        password = password,
        password2 = password2
    )
}

fun RegisterModel.toUI() = RegisterUI(
    username = username,
    email = email,
    password = password,
    password2 = password2
)

fun RegisterUI.toRegisterModel()=RegisterModel(
    username,
    email,
    password,
    password2
)
