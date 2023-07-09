package com.example.stylescope.domain.model.review

import com.google.gson.annotations.SerializedName

data class ReviewSendModel(
    val rank: Int,
    val text: String
)


data class ReviewAnswerModel(
    val id: Int,
    val rank: Int,
    val company: String,
    val text: String,
    val userPhoto: String
)