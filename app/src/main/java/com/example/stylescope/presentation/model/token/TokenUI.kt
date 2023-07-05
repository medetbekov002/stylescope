package com.example.stylescope.presentation.model.token

import com.example.stylescope.domain.model.*

data class GetTokenAnswerUI(
    val refresh:String,
    val access:String
)

fun GetTokenAnswerModel.toGetTokenAnswerUI()=GetTokenAnswerUI(refresh, access)

data class GetTokenUI(
    val username:String,
    val password:String
)

fun GetTokenUI.toGetTokenModel()= GetTokenModel(username, password)

data class RefreshTokenUI(
    val refresh:String
)
fun RefreshTokenUI.toRefreshTokenModel() = RefreshTokenModel(refresh)

data class RefreshTokenAnswerUI(
    val access:String
)

fun RefreshTokenAnswerModel.toRefreshTokenAnswerUI()= RefreshTokenAnswerUI(access)

data class VerifyTokenUI(
    val token:String
)

fun VerifyTokenUI.toVerifyTokenModel() = VerifyTokenModel(token)

data class VerifyTokenAnswerUI(
    val detail:String?=null,
    val code:String?=null
)

fun VerifyTokenAnswerModel.toVerifyTokenAnswerUI() = VerifyTokenAnswerUI(detail, code)