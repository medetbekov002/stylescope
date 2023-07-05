package com.example.stylescope.data.remote.dtos.confirm

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.confirm.ConfirmAnswerModel
import com.example.stylescope.domain.model.confirm.ConfirmModel
import com.example.stylescope.domain.model.confirm.RecoverConfirmModel
import com.example.stylescope.domain.model.confirm.ResendConfirmModel

data class ConfirmDto(
    val code: Int
) : DataMapper<ConfirmModel> {
    override fun toDomain() = ConfirmModel(code)
}

data class ResendConfirmDto(
    val username: String
)

data class RecoverConfirmDto(
    val code: Int,
    val new_password: String,
    val new_password2: String
)

data class ConfirmAnswerDto(
    val refresh_token:String?=null,
    val access_token:String?=null
):DataMapper<ConfirmAnswerModel> {
    override fun toDomain()= ConfirmAnswerModel(refresh_token, access_token)
}

fun RecoverConfirmModel.toRecoverConfirmDto() = RecoverConfirmDto(code, new_password, new_password2)
fun ResendConfirmModel.toResendConfirmDto() = ResendConfirmDto(username)
fun ConfirmModel.toConfirmDto() = ConfirmDto(code)
