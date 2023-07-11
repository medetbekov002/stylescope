package com.example.stylescope.domain.use_cases.reviewdesigner

import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.repository.reviewdesigner.ReviewDesignerRepository

class ReviewDesignerUseCase(private val repository: ReviewDesignerRepository) {

    fun sendDesignerReview(model: ReviewSendModel, id: String) =
        repository.sendDesignerReview(model, id)

    fun deleteDesignerReview(designerId: String, id: String) =
        repository.deleteDesignerReview(designerId, id)

    fun editDesignerReview(designerId: String, id: String, edit: ReviewSendModel) =
        repository.editDesignerReview(designerId, id, edit)

    fun getDesignerUserReview(designerId: String) = repository.getDesignerUserReview(designerId)
}