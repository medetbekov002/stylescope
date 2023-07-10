package com.example.stylescope.domain.use_cases.favorite

import com.example.stylescope.domain.model.company.CompanyFavoriteModel
import com.example.stylescope.domain.repository.favorite.SaveFavoriteCompanyRepository

class SaveFavoriteCompanyUseCase(private val repository: SaveFavoriteCompanyRepository) {

    operator fun invoke(model: CompanyFavoriteModel, id: String) =
        repository.saveFavoriteCompany(model = model, id = id)
}