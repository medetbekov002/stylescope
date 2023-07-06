package com.example.stylescope.presentation.ui.fragments.pager.designer

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.designer.GetDesignerUseCase
import com.example.stylescope.presentation.model.designer.DesignerUI
import com.example.stylescope.presentation.model.designer.toUI
import kotlinx.coroutines.flow.asStateFlow

class DesignerViewModel(
    private val getDesignerUseCase: GetDesignerUseCase
) : BaseViewModel() {

    private val _designerState = mutableUIStateFlow<List<DesignerUI>>()
    val companyState get() = _designerState.asStateFlow()

    init {
        getCompanies()
    }
    fun getCompanies() {
        getDesignerUseCase().gatherRequest(_designerState) { designerModels -> designerModels.map { it.toUI() }}
    }
}