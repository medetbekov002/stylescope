package com.example.stylescope.presentation.module

import com.example.stylescope.presentation.ui.fragments.pager.company.CompaniesViewModel
import com.example.stylescope.presentation.ui.fragments.pager.company.detail.DetailCompanyVIewModel
import com.example.stylescope.presentation.ui.fragments.pager.designer.DesignerViewModel
import com.example.stylescope.presentation.ui.fragments.main.MainViewModel
import com.example.stylescope.presentation.ui.fragments.profile.ProfileViewModel
import com.example.stylescope.presentation.ui.fragments.profile.dialog.UpdateUserImageViewModel
import com.example.stylescope.presentation.ui.fragments.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CompaniesViewModel(get()) }
    viewModel { DetailCompanyVIewModel(get()) }
    viewModel { DesignerViewModel(get()) }
    viewModel { MainViewModel(get(), get()) }
    viewModel { ProfileViewModel(get(), get()) }
    viewModel { UpdateUserImageViewModel(get()) }
}