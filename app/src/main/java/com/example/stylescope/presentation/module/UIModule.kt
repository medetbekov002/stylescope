package com.example.stylescope.presentation.module

import com.example.stylescope.presentation.ui.fragments.pager.company.CompaniesViewModel
import com.example.stylescope.presentation.ui.fragments.pager.company.detail.DetailCompanyVIewModel
import com.example.stylescope.presentation.ui.fragments.pager.designer.DesignerViewModel
import com.example.stylescope.presentation.ui.fragments.main.MainViewModel
import com.example.stylescope.presentation.ui.fragments.pager.designer.detail.DetailDesignerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CompaniesViewModel(get()) }
    viewModel { DetailCompanyVIewModel(get()) }
    viewModel { DetailDesignerViewModel(get()) }
    viewModel { DesignerViewModel(get()) }
    viewModel { MainViewModel(get(), get()) }
}