package com.example.stylescope.presentation.module

import com.example.stylescope.presentation.ui.fragments.changepassword.ChangePasswordViewModel
import com.example.stylescope.presentation.ui.fragments.confirm.ConfirmCodeViewModel
import com.example.stylescope.presentation.ui.fragments.favorite.FavoriteViewModel
import com.example.stylescope.presentation.ui.fragments.inter.InterViewModel
import com.example.stylescope.presentation.ui.fragments.pager.company.CompaniesViewModel
import com.example.stylescope.presentation.ui.fragments.pager.company.detail.DetailCompanyVIewModel
import com.example.stylescope.presentation.ui.fragments.pager.designer.DesignerViewModel
import com.example.stylescope.presentation.ui.fragments.main.MainViewModel
import com.example.stylescope.presentation.ui.fragments.myreviews.MyReviewsViewModel
import com.example.stylescope.presentation.ui.fragments.onboarding.OnBoardingViewModel
import com.example.stylescope.presentation.ui.fragments.recovery.RecoveryViewModel
import com.example.stylescope.presentation.ui.fragments.register.RegisterViewModel
import com.example.stylescope.presentation.ui.token.TokenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CompaniesViewModel(get()) }
    viewModel { DetailCompanyVIewModel(get()) }
    viewModel { DesignerViewModel(get()) }
    viewModel { MainViewModel(get(), get()) }
    viewModel { InterViewModel(get()) }
    viewModel { RecoveryViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { ConfirmCodeViewModel(get()) }
    viewModel { ChangePasswordViewModel(get()) }
    viewModel { TokenViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { OnBoardingViewModel() }
    viewModel { MyReviewsViewModel(get()) }
}