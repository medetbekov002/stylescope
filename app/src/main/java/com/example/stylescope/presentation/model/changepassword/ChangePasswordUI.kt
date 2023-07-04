package com.example.stylescope.presentation.model.changepassword

import com.example.stylescope.domain.model.changepassword.ChangePasswordAnswerModel
import com.example.stylescope.domain.model.changepassword.ChangePasswordModel

data class ChangePasswordUI(
    val code:String,
    val new_password:String,
    val new_password2: String
)

data class ChangePasswordAnswerUI(
    val code:List<String>?=null
)

fun ChangePasswordAnswerModel.toChangePasswordAnswerUI()=ChangePasswordAnswerUI(code?.map { it.toString() })
fun ChangePasswordUI.toChangePasswordModel() = ChangePasswordModel(code, new_password, new_password2)