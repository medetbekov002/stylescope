package com.example.stylescope.data.remote.dtos.token

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.*

data class GetTokenAnswerDto(
    val refresh: String,
    val access: String
) : DataMapper<GetTokenAnswerModel> {
    override fun toDomain() = GetTokenAnswerModel(refresh, access)
}

data class GetTokenDto(
    val username: String,
    val password: String
)

fun GetTokenModel.toGetTokenDto() = GetTokenDto(username, password)


data class RefreshTokenDto(
    val refresh: String
)

fun RefreshTokenModel.toRefreshTokenDto() = RefreshTokenDto(refresh)

data class RefreshTokenAnswerDto(
    val access: String
) : DataMapper<RefreshTokenAnswerModel> {
    override fun toDomain() = RefreshTokenAnswerModel(access)
}

data class VerifyTokenDto(
    val token: String
)

fun VerifyTokenModel.toVerifyTokenDto() = VerifyTokenDto(token)

data class VerifyTokenAnswerDto(
    val detail: String?=null,
    val code: String?=null
) : DataMapper<VerifyTokenAnswerModel> {
    override fun toDomain() = VerifyTokenAnswerModel(detail, code)
}