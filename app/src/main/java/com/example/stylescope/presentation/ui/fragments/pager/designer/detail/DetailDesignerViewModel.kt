package com.example.stylescope.presentation.ui.fragments.pager.designer.detail

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.designer.GetDetailDesignerUseCase
import com.example.stylescope.presentation.model.designer.DesignerDetailUI
import com.example.stylescope.presentation.model.designer.toUI
import kotlinx.coroutines.flow.asStateFlow

class DetailDesignerViewModel(private val getDetailDesignerUseCase: GetDetailDesignerUseCase) : BaseViewModel() {

    private val _state = mutableUIStateFlow<DesignerDetailUI>()
    val state = _state.asStateFlow()

    fun getDetailCompanies(id: Int) {
        getDetailDesignerUseCase(id).gatherRequest(_state) { it.toUI() }
    }
}