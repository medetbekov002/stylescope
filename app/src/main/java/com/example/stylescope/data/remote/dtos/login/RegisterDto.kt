package com.example.stylescope.data.remote.dtos.login

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.login.RegisterModel

data class RegisterDto(
    val username: String,
    val email: String,
    val password: String,
    val password2: String
):DataMapper<RegisterModel>{
    override fun toDomain() = RegisterModel(
        username,
        email,
        password,
        password2
    )
}

fun RegisterModel.toRegisterDto()=RegisterDto(
    username,
    email,
    password,
    password2
)

data class ResendConfirmCodeDto(
    val username: String
)
