package com.example.stylescope.data.remote.repository.review

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.review.toDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.repository.review.ReviewRepository
import kotlinx.coroutines.flow.Flow

class ReviewRepositoryImpl(private val api: ApiService): ReviewRepository {
    override fun sendReview(
        model: ReviewSendModel,
        id: String
    ): Flow<Either<String, ReviewAnswerModel>> = makeNetworkRequest {
        api.sendReview(model.toDto(), id).toDomain()
    }
}