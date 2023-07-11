package com.example.stylescope.domain.repository.reviewcompany

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.review.ReviewAnswerModel
import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.model.review.UserReviewsModel
import kotlinx.coroutines.flow.Flow

interface ReviewCompanyRepository {

    fun sendCompanyReview(model: ReviewSendModel, id: String): Flow<Either<String, ReviewAnswerModel>>

    fun deleteCompanyReview(companyId:String, id:String):Flow<Either<String,List<String>>>

    fun editCompanyReview(companyId:String, id:String, edit:ReviewSendModel):Flow<Either<String,ReviewAnswerModel>>

    fun getCompaniesUserReview(companyId: String):Flow<Either<String,UserReviewsModel>>

}