package com.example.stylescope.domain.model.review

import com.google.gson.annotations.SerializedName

data class ReviewSendModel(
    val rank: String,
    val text: String
)


data class ReviewAnswerModel(
    val id: Int,
    val rank: String,
    val company: String,
    val text: String,
    val userPhoto: String
)