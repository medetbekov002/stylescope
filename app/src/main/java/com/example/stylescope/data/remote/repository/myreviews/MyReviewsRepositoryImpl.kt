package com.example.stylescope.data.remote.repository.myreviews

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.myreviews.MyReviewsModel
import com.example.stylescope.domain.repository.myreviews.MyReviewsRepository
import kotlinx.coroutines.flow.Flow

class MyReviewsRepositoryImpl(private val apiService: ApiService) : MyReviewsRepository {
    override fun getReviews(): Flow<Either<String, MyReviewsModel>> = makeNetworkRequest {
        apiService.getReviews().toDomain()
    }
}