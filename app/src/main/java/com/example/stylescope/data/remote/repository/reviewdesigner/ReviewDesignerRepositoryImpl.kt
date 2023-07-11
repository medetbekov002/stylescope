package com.example.stylescope.data.remote.repository.reviewdesigner

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.review.toDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.model.review.UserReviewsModel
import kotlinx.coroutines.flow.Flow
import com.example.stylescope.domain.repository.reviewdesigner.ReviewDesignerRepository

class ReviewDesignerRepositoryImpl(private val apiService: ApiService) :ReviewDesignerRepository {
    override fun sendDesignerReview(
        model: ReviewSendModel,
        id: String
    ): Flow<Either<String, ReviewAnswerModel>> = makeNetworkRequest {
        apiService.sendDesignerReview(model.toDto(), id).toDomain()
    }

    override fun deleteDesignerReview(
        designerId: String,
        id: String
    ): Flow<Either<String, List<String>>> = makeNetworkRequest {
        apiService.deleteDesignerReview(designerId, id)
    }

    override fun editDesignerReview(
        designerId: String,
        id: String,
        edit: ReviewSendModel
    ): Flow<Either<String, ReviewAnswerModel>> = makeNetworkRequest {
        apiService.editDesignerReview(designerId, id, edit.toDto()).toDomain()
    }

    override fun getDesignerUserReview(designerId: String): Flow<Either<String, UserReviewsModel>> = makeNetworkRequest{
        apiService.getDesignerUserReview(designerId).toDomain()
    }
}