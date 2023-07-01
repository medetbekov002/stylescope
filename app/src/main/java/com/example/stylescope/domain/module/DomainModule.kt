package com.example.stylescope.domain.module

import com.example.stylescope.domain.use_cases.about_us.GetAboutUsUseCase
import com.example.stylescope.domain.use_cases.company.GetCompanyUseCase
import com.example.stylescope.domain.use_cases.company.GetDetailCompanyUseCase
import com.example.stylescope.domain.use_cases.designer.GetDesignerUseCase
import com.example.stylescope.domain.use_cases.designer.GetDetailDesignerUseCase
import com.example.stylescope.domain.use_cases.login.LogInUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetCompanyUseCase(get()) }
    factory { GetDetailCompanyUseCase(get()) }
    factory { GetDesignerUseCase(get()) }
    factory { GetDetailDesignerUseCase(get()) }
    factory { GetAboutUsUseCase(get()) }
    factory { LogInUseCase(get()) }
}