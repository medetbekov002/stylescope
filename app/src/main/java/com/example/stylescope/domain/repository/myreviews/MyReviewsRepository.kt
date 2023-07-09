package com.example.stylescope.domain.repository.myreviews

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.myreviews.MyReviewsModel
import kotlinx.coroutines.flow.Flow

interface MyReviewsRepository {

    fun getReviews():Flow<Either<String,MyReviewsModel>>
}