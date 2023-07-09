package com.example.stylescope.domain.module

import com.example.stylescope.domain.use_cases.about_us.GetAboutUsUseCase
import com.example.stylescope.domain.use_cases.changepassword.ChangePasswordUseCase
import com.example.stylescope.domain.use_cases.company.GetCompanyUseCase
import com.example.stylescope.domain.use_cases.company.GetDetailCompanyUseCase
import com.example.stylescope.domain.use_cases.confirm.ConfirmUseCase
import com.example.stylescope.domain.use_cases.designer.GetDesignerUseCase
import com.example.stylescope.domain.use_cases.designer.GetDetailDesignerUseCase
import com.example.stylescope.domain.use_cases.favorite.FavoriteUseCase
import com.example.stylescope.domain.use_cases.login.LogInUseCase
import com.example.stylescope.domain.use_cases.myreviews.MyReviewsUseCase
import com.example.stylescope.domain.use_cases.recover.RecoverUseCase
import com.example.stylescope.domain.use_cases.register.RegisterUseCase
import com.example.stylescope.domain.use_cases.token.TokenUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetCompanyUseCase(get()) }
    factory { GetDetailCompanyUseCase(get()) }
    factory { GetDesignerUseCase(get()) }
    factory { GetDetailDesignerUseCase(get()) }
    factory { GetAboutUsUseCase(get()) }
    factory { LogInUseCase(get()) }
    factory { RecoverUseCase(get()) }
    factory { RegisterUseCase(get()) }
    factory { ConfirmUseCase(get()) }
    factory { ChangePasswordUseCase(get()) }
    factory { TokenUseCase(get()) }
    factory { FavoriteUseCase(get()) }
    factory { MyReviewsUseCase(get()) }
}