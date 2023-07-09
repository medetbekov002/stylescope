package com.example.stylescope.domain.repository.review

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import kotlinx.coroutines.flow.Flow

interface ReviewRepository {

    fun sendReview(model: ReviewSendModel, id: String): Flow<Either<String, ReviewAnswerModel>>
}