package com.example.stylescope.data.remote.dtos.review

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.model.review.UserReviewsModel
import com.google.gson.annotations.SerializedName

data class ReviewSendDto(
    val rank: Int?=null,
    val text: String?=null
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

data class UserReviewsDto(
    val user_reviews:List<ReviewAnswerDto>?=null
):DataMapper<UserReviewsModel>{
    override fun toDomain()= UserReviewsModel(
        user_reviews = user_reviews?.map { it.toDomain() }
    )

}


data class ReviewAnswerDto(
    val id: Int,
    val rank: Int?=null,
    val text: String?=null,
    @SerializedName("user_photo")
    val userPhoto: String?=null,
    val time_since_published:String?=null,
    val first_name:String?=null,
    val last_name:String?=null
): DataMapper<ReviewAnswerModel> {
    override fun toDomain() = ReviewAnswerModel(
        id = id,
        rank = rank,
        text = text,
        userPhoto = userPhoto,
        time_since_published = time_since_published,
        first_name = first_name,
        last_name = last_name
    )
}


