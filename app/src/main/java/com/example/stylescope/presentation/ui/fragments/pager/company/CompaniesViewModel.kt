package com.example.stylescope.presentation.ui.fragments.pager.company

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.company.GetCompanyUseCase
import com.example.stylescope.domain.use_cases.favorite.SaveFavoriteCompanyUseCase
import com.example.stylescope.presentation.model.company.CompanyFavoriteUI
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.model.company.toUI
import kotlinx.coroutines.flow.asStateFlow

class CompaniesViewModel(
    private val getCompanyUseCase: GetCompanyUseCase,
    private val saveFavoriteCompanyUseCase: SaveFavoriteCompanyUseCase
) : BaseViewModel() {

    private val _companyState = mutableUIStateFlow<List<CompanyUI>>()
    val companyState get() = _companyState.asStateFlow()

    private val _saveCompanyState = mutableUIStateFlow<List<String>>()
    val saveCompanyState get() = _saveCompanyState.asStateFlow()

    init {
        getCompanies()
    }

    private fun getCompanies() {
        getCompanyUseCase().gatherRequest(_companyState) { companyModels -> companyModels.map { it.toUI() } }
    }

    fun saveFavoriteCompany(model: CompanyFavoriteUI, id: String) =
        saveFavoriteCompanyUseCase(model = model.toDomain(), id = id).gatherRequest(
            _saveCompanyState
        ) { it }
}