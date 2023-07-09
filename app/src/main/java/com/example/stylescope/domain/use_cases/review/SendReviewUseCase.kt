package com.example.stylescope.domain.use_cases.review

import com.example.stylescope.domain.model.review.ReviewSendModel
import com.example.stylescope.domain.repository.review.ReviewRepository

class SendReviewUseCase(private val repo: ReviewRepository) {


    operator fun invoke(model: ReviewSendModel, id: String) = repo.sendReview(model, id)
}