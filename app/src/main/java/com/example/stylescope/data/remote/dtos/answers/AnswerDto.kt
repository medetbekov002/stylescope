package com.example.stylescope.data.remote.dtos.answers

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.answers.ListAnswerModel


data class AnswerDto(
    val data:String
): DataMapper<AnswerModel> {
    override fun toDomain()= AnswerModel(data)
}

data class ListAnswerDto(
    val data: List<String>
):DataMapper<ListAnswerModel>{
    override fun toDomain()= ListAnswerModel(data.map { it })
}