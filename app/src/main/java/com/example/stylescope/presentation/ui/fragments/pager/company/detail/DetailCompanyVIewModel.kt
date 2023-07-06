package com.example.stylescope.presentation.ui.fragments.pager.company.detail

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.company.GetDetailCompanyUseCase
import com.example.stylescope.presentation.model.company.CompanyDetailUI
import com.example.stylescope.presentation.model.company.toUI
import kotlinx.coroutines.flow.asStateFlow

class DetailCompanyVIewModel(private val getDetailCompanyUseCase: GetDetailCompanyUseCase) : BaseViewModel() {


    private val _state = mutableUIStateFlow<CompanyDetailUI>()
    val state = _state.asStateFlow()

    fun getDetailCompanies(id: Int) {
        getDetailCompanyUseCase(id).gatherRequest(_state) { it.toUI() }
    }
}