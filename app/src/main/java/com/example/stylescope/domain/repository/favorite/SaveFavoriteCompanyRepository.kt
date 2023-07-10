package com.example.stylescope.domain.repository.favorite

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.company.CompanyFavoriteModel
import kotlinx.coroutines.flow.Flow

interface SaveFavoriteCompanyRepository {

    fun saveFavoriteCompany(model: CompanyFavoriteModel, id: String): Flow<Either<String, List<String>>>
}