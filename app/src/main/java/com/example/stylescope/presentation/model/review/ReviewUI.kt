package com.example.stylescope.presentation.model.review

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.data.remote.dtos.review.ReviewAnswerDto
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.model.review.UserReviewsModel

data class ReviewSendUI(
    val rank: Int?=null,
    val text: String?=null
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

data class UserReviewsUI(
    val user_reviews:List<ReviewAnswerUI>?=null
)

fun UserReviewsModel.toUI() = UserReviewsUI(
    user_reviews = user_reviews?.map { it.toUI() }
)

data class ReviewAnswerUI(
    val id: Int,
    val rank: Int?=null,
    val text: String?=null,
    val userPhoto: String?=null,
    val time_since_published:String?=null,
    val first_name:String?=null,
    val last_name:String?=null
)

fun ReviewAnswerModel.toUI() = ReviewAnswerUI(
    id = id,
    rank = rank,
    text = text,
    userPhoto = userPhoto,
    time_since_published = time_since_published,
    first_name = first_name,
    last_name = last_name
)