package com.example.stylescope.domain.module

import com.example.stylescope.domain.use_cases.about_us.GetAboutUsUseCase
import com.example.stylescope.domain.use_cases.company.GetCompanyUseCase
import com.example.stylescope.domain.use_cases.company.GetDetailCompanyUseCase
import com.example.stylescope.domain.use_cases.designer.GetDesignerUseCase
import com.example.stylescope.domain.use_cases.designer.GetDetailDesignerUseCase
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
    factory { GetUserProfileUseCase(get()) }
    factory { UpdateUserProfileUseCase(get()) }
    factory { UpdateUserImageUseCase(get()) }
}