package com.example.stylescope.data.remote.repository.favorite

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.designer.toData
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.designer.DesignerFavoriteModel
import com.example.stylescope.domain.repository.favorite.SaveFavoriteDesignerRepository
import kotlinx.coroutines.flow.Flow

class SaveFavoriteDesignerRepositoryImpl(private val api: ApiService) : SaveFavoriteDesignerRepository {
    override fun saveFavoriteDesigner(
        model: DesignerFavoriteModel,
        id: String
    ): Flow<Either<String, List<String>>> =
        makeNetworkRequest { api.addFavoriteDesigner(model = model.toData(), id = id) }
}