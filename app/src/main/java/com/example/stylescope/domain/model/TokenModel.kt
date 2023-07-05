package com.example.stylescope.domain.model

data class GetTokenAnswerModel(
    val refresh:String,
    val access:String
)

data class GetTokenModel(
    val username:String,
    val password:String
)


data class RefreshTokenModel(
    val refresh:String
)

data class RefreshTokenAnswerModel(
    val access:String
)

data class VerifyTokenModel(
    val token:String
)

data class VerifyTokenAnswerModel(
    val detail:String?=null,
    val code:String?=null
)