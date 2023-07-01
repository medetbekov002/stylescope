package com.example.stylescope.data.mapper

import com.example.stylescope.data.remote.dtos.login.LoginDto
import com.example.stylescope.domain.model.login.LoginModel

fun LoginModel.toLoginDto()= LoginDto(username,password)


