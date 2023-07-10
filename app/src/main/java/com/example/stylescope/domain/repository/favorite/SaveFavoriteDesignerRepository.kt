package com.example.stylescope.domain.repository.favorite

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.designer.DesignerFavoriteModel
import kotlinx.coroutines.flow.Flow

interface SaveFavoriteDesignerRepository {

    fun saveFavoriteDesigner(
        model: DesignerFavoriteModel,
        id: String
    ): Flow<Either<String, List<String>>>
}