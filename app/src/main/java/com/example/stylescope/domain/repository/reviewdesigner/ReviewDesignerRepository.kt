package com.example.stylescope.domain.repository.reviewdesigner

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.model.review.UserReviewsModel
import kotlinx.coroutines.flow.Flow

interface ReviewDesignerRepository {

    fun sendDesignerReview(
        model: ReviewSendModel,
        id: String
    ): Flow<Either<String, ReviewAnswerModel>>

    fun deleteDesignerReview(designerId: String, id: String): Flow<Either<String, List<String>>>

    fun editDesignerReview(
        designerId: String,
        id: String,
        edit: ReviewSendModel
    ): Flow<Either<String, ReviewAnswerModel>>

    fun getDesignerUserReview(designerId: String): Flow<Either<String, UserReviewsModel>>
}