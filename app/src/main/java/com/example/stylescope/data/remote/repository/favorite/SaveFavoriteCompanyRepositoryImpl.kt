package com.example.stylescope.data.remote.repository.favorite

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.company.toData
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.company.CompanyFavoriteModel
import com.example.stylescope.domain.repository.favorite.SaveFavoriteCompanyRepository
import kotlinx.coroutines.flow.Flow

class SaveFavoriteCompanyRepositoryImpl(private val api: ApiService) : SaveFavoriteCompanyRepository{
    override fun saveFavoriteCompany(
        model: CompanyFavoriteModel,
        id: String
    ): Flow<Either<String, List<String>>> =
        makeNetworkRequest { api.addFavoriteCompany(model = model.toData(), id = id) }
}