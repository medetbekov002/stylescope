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
import com.example.stylescope.domain.use_cases.recover.RecoverUseCase
import com.example.stylescope.domain.use_cases.register.RegisterUseCase
import com.example.stylescope.domain.use_cases.review.SendReviewUseCase
import com.example.stylescope.domain.use_cases.token.TokenUseCase
import com.example.stylescope.domain.use_cases.user.profile.GetUserProfileUseCase
import com.example.stylescope.domain.use_cases.user.profile.UpdateUserImageUseCase
import com.example.stylescope.domain.use_cases.user.profile.UpdateUserProfileUseCase
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
    factory { GetUserProfileUseCase(get()) }
    factory { UpdateUserProfileUseCase(get()) }
    factory { UpdateUserImageUseCase(get()) }
    factory { SendReviewUseCase(get()) }
}