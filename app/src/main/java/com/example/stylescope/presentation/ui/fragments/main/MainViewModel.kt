package com.example.stylescope.presentation.ui.fragments.main

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.company.GetCompanyUseCase
import com.example.stylescope.domain.use_cases.designer.GetDesignerUseCase
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.model.company.toUI
import com.example.stylescope.presentation.model.designer.DesignerUI
import com.example.stylescope.presentation.model.designer.toUI
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val getCompanyUseCase: GetCompanyUseCase,
    private val getDesignerUseCase: GetDesignerUseCase
): BaseViewModel() {


    private val _companyState = mutableUIStateFlow<List<CompanyUI>>()
    val companyState get() = _companyState.asStateFlow()

    private val _designerState = mutableUIStateFlow<List<DesignerUI>>()
    val designerState get() = _designerState.asStateFlow()
    init {
        getCompanies()
    }
    init {
        getDesigners()
    }

    private fun getCompanies() {
        getCompanyUseCase().gatherRequest(_companyState) { companyModels -> companyModels.map { it.toUI() } }
    }

    private fun getDesigners() {
        getDesignerUseCase().gatherRequest(_designerState) { designerModels -> designerModels.map { it.toUI() }}
    }
}