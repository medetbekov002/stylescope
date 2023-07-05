package com.example.stylescope.data.remote.repository.favorite

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.favorite.FavoriteItemModel
import com.example.stylescope.domain.repository.favorite.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(private val apiService: ApiService):FavoriteRepository {
    override fun getFavorites(): Flow<Either<String, FavoriteItemModel>> = makeNetworkRequest {
        apiService.getFavorite().toDomain()
    }
}