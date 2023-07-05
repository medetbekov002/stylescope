package com.example.stylescope.presentation.model.answers

import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.answers.ListAnswerModel

data class AnswerUI(
    val data:String?=null
)

data class ListAnswerUI(
    val data: List<String>
)

fun ListAnswerModel.toListAnswerUI()=ListAnswerUI(
    data.map { it }
)
fun AnswerModel.toLogInAnswerUI() = AnswerUI(data)