package com.example.stylescope.presentation.model.login

import com.example.stylescope.domain.model.login.LoginModel


data class LoginUI(
    val username: String,
    val password: String
)

fun LoginUI.toLogInModel() = LoginModel(username, password)



