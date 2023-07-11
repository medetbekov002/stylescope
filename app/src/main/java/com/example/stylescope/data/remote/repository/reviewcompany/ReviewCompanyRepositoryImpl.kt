package com.example.stylescope.data.remote.repository.reviewcompany

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.review.toDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.model.review.UserReviewsModel
import com.example.stylescope.domain.repository.reviewcompany.ReviewCompanyRepository
import com.example.stylescope.presentation.model.answers.toLogInAnswerUI
import kotlinx.coroutines.flow.Flow

class ReviewCompanyRepositoryImpl(private val api: ApiService): ReviewCompanyRepository {
    override fun sendCompanyReview(
        model: ReviewSendModel,
        id: String
    ): Flow<Either<String, ReviewAnswerModel>> = makeNetworkRequest {
        api.sendCompanyReview(model.toDto(), id).toDomain()
    }

    override fun deleteCompanyReview(companyId: String, id: String): Flow<Either<String,List<String>>> = makeNetworkRequest {
        api.deleteCompanyReview(companyId,id)
    }

    override fun editCompanyReview(
        companyId: String,
        id: String,
        edit:ReviewSendModel
    ): Flow<Either<String, ReviewAnswerModel>> = makeNetworkRequest{
        api.editCompanyReview(companyId, id,edit.toDto()).toDomain()
    }

    override fun getCompaniesUserReview(companyId: String): Flow<Either<String, UserReviewsModel>> = makeNetworkRequest {
        api.getCompaniesUserReview(companyId).toDomain()
    }
}