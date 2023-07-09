package com.example.stylescope.data.remote.dtos.review

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.google.gson.annotations.SerializedName

data class ReviewSendDto(
    val rank: String,
    val text: String
): DataMapper<ReviewSendModel> {
    override fun toDomain() = ReviewSendModel(
        rank = rank,
        text = text
    )
}


fun ReviewSendModel.toDto() = ReviewSendDto(
    rank = rank,
    text = text
)

data class ReviewAnswerDto(
    val id: Int,
    val rank: String,
    val company: String,
    val text: String,
    @SerializedName("user_photo")
    val userPhoto: String
): DataMapper<ReviewAnswerModel> {
    override fun toDomain() = ReviewAnswerModel(
        id = id,
        rank = rank,
        company = company,
        text = text,
        userPhoto = userPhoto
    )
}