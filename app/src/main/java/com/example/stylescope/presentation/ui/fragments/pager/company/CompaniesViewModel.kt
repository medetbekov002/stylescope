package com.example.stylescope.presentation.ui.fragments.pager.company

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.company.GetCompanyUseCase
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.model.company.toUI
import kotlinx.coroutines.flow.asStateFlow

class CompaniesViewModel(
    private val getCompanyUseCase: GetCompanyUseCase
) : BaseViewModel() {

    private val _companyState = mutableUIStateFlow<List<CompanyUI>>()
    val companyState get() = _companyState.asStateFlow()

    init {
        getCompanies()
    }
    fun getCompanies() {
        getCompanyUseCase().gatherRequest(_companyState) { companyModels -> companyModels.map { it.toUI() }}
    }
}