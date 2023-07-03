package com.example.stylescope.data.remote.dtos.recover

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.recover.RecoverModel

data class RecoverDto(
    val email:String
):DataMapper<RecoverModel>{
    override fun toDomain()=RecoverModel(email)
}

fun RecoverModel.toRecoverDto()=RecoverDto(email)