package com.example.stylescope.data.remote.module

import com.example.stylescope.data.remote.repository.company.CompanyRepositoryImpl
import com.example.stylescope.data.remote.repository.designer.DesignerRepositoryImpl
import com.example.stylescope.domain.repository.company.CompanyRepository
import com.example.stylescope.domain.repository.designer.DesignerRepository
import org.koin.dsl.module

val repoModule = module {
    single<CompanyRepository> { CompanyRepositoryImpl(get()) }
    single<DesignerRepository> { DesignerRepositoryImpl(get()) }
}