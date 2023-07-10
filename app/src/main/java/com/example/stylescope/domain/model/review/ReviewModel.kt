package com.example.stylescope.domain.model.review

import com.example.stylescope.data.remote.dtos.review.ReviewAnswerDto
import com.google.gson.annotations.SerializedName

data class ReviewSendModel(
    val rank: Int?=null,
    val text: String?=null
)


data class ReviewAnswerModel(
    val id: Int,
    val rank: Int?=null,
    val text: String?=null,
    val userPhoto: String?=null,
    val time_since_published:String?=null,
    val first_name:String?=null,
    val last_name:String?=null
)

data class UserReviewsModel(
    val user_reviews:List<ReviewAnswerModel>?=null
)