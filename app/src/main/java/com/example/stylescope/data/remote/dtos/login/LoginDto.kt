package com.example.stylescope.data.remote.dtos.login

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.login.LoginModel

data class LoginDto(
    val username: String,
    val password: String
):DataMapper<LoginModel>{
    override fun toDomain()=LoginModel(username,password)
}

fun LoginModel.toLoginDto()= LoginDto(username,password)





