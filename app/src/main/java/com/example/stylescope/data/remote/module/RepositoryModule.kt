package com.example.stylescope.data.remote.module

import com.example.stylescope.data.remote.repository.company.CompanyRepositoryImpl
import com.example.stylescope.data.remote.repository.designer.DesignerRepositoryImpl
import com.example.stylescope.data.remote.repository.login.LogInRepositoryImpl
import com.example.stylescope.domain.repository.company.CompanyRepository
import com.example.stylescope.domain.repository.designer.DesignerRepository
import com.example.stylescope.domain.repository.login.LogInRepository
import org.koin.dsl.module

val repoModule = module {
    single<CompanyRepository> { CompanyRepositoryImpl(get()) }
    single<DesignerRepository> { DesignerRepositoryImpl(get()) }
    single<LogInRepository> { LogInRepositoryImpl(get()) }
}