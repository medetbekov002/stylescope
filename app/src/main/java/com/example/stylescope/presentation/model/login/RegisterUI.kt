package com.example.stylescope.presentation.model.login

import com.example.stylescope.domain.model.login.RegisterModel

data class RegisterUI(
    val username: String,
    val email: String,
    val password: String,
    val password2: String
)

fun RegisterUI.toRegisterModel()=RegisterModel(
    username,
    email,
    password,
    password2
)
