package com.example.stylescope.domain.model.changepassword

data class ChangePasswordModel(
    val code:String,
    val new_password:String,
    val new_password2: String
)

data class ChangePasswordAnswerModel(
    val code:List<String>?=null
)