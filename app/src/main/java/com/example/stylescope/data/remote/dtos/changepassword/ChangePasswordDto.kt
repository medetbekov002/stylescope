package com.example.stylescope.data.remote.dtos.changepassword

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.changepassword.ChangePasswordAnswerModel
import com.example.stylescope.domain.model.changepassword.ChangePasswordModel

data class ChangePasswordDto(
    val code:String,
    val new_password:String,
    val new_password2: String
):DataMapper<ChangePasswordModel>{
    override fun toDomain()= ChangePasswordModel(code, new_password, new_password2)
}

data class ChangePasswordAnswerDto(
    val code:List<String>?=null
):DataMapper<ChangePasswordAnswerModel> {
    override fun toDomain()= ChangePasswordAnswerModel(code?.map { it })
}

fun ChangePasswordModel.toChangePasswordDto()=ChangePasswordDto(code, new_password, new_password2)
