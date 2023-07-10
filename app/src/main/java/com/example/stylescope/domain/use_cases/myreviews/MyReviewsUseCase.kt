package com.example.stylescope.domain.use_cases.myreviews

import com.example.stylescope.domain.repository.myreviews.MyReviewsRepository

class MyReviewsUseCase(private val repository:MyReviewsRepository) {

    operator fun invoke() = repository.getReviews()
}