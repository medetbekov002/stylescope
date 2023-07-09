package com.example.stylescope.presentation.model.review

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel

data class ReviewSendUI(
    val rank: String,
    val text: String
): DataMapper<ReviewSendModel> {
    override fun toDomain() = ReviewSendModel(
        rank=rank,
        text = text
    )
}

fun ReviewSendModel.toUI() = ReviewSendUI(
    rank = rank,
    text = text
)


data class ReviewAnswerUI(
    val id: Int,
    val rank: String,
    val company: String,
    val text: String,
    val userPhoto: String
)

fun ReviewAnswerModel.toUI() = ReviewAnswerUI(
    id = id,
    rank = rank,
    company = company,
    text = text,
    userPhoto = userPhoto
)