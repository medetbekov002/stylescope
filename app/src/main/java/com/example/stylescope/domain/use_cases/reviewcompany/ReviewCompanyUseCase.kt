package com.example.stylescope.domain.use_cases.reviewcompany

import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.repository.reviewcompany.ReviewCompanyRepository

class ReviewCompanyUseCase(private val repo: ReviewCompanyRepository) {


    fun sendCompanyReview(model: ReviewSendModel, id: String) = repo.sendCompanyReview(model, id)
    fun deleteCompanyReview(companyId:String, id: String) = repo.deleteCompanyReview(companyId, id)
    fun editCompanyReview(companyId: String, id: String, edit:ReviewSendModel) = repo.editCompanyReview(companyId, id,edit)
    fun getCompanyUserReview(companyId:String) = repo.getCompaniesUserReview(companyId)
}