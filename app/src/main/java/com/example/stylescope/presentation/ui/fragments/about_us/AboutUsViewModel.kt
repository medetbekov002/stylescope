package com.example.stylescope.presentation.ui.fragments.about_us

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.about_us.GetAboutUsUseCase
import com.example.stylescope.presentation.model.about_us.AboutUI
import kotlinx.coroutines.flow.asStateFlow

class AboutUsViewModel(
    private val getAboutUsUseCase: GetAboutUsUseCase
) : BaseViewModel() {

    private val _aboutUsState = mutableUIStateFlow<List<AboutUI>>()
    val aboutUsState get() = _aboutUsState.asStateFlow()

//    private fun getAboutUs() {
//        getAboutUsUseCase().gatherRequest(_aboutUsState) { us -> us.map {it.toUI}}
//    }
}