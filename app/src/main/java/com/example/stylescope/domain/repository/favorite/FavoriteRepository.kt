package com.example.stylescope.domain.repository.favorite

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.favorite.FavoriteItemModel
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getFavorites(): Flow<Either<String, List<FavoriteItemModel>>>
}