package com.example.stylescope.presentation.model.login
import com.example.stylescope.domain.model.login.LogInAnswerModel
import com.example.stylescope.domain.model.login.LoginModel


data class LoginUI(
    val username: String,
    val password: String
)

data class LogInAnswerUI(
    val data:String
)

fun LogInAnswerModel.toLogInAnswerUI() = LogInAnswerUI(data)
fun LoginUI.toLogInModel() = LoginModel(username, password)



