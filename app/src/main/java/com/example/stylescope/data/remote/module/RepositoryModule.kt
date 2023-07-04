package com.example.stylescope.data.remote.module

import com.example.stylescope.data.remote.repository.changepassword.ChangePasswordRepositoryImpl
import com.example.stylescope.data.remote.repository.company.CompanyRepositoryImpl
import com.example.stylescope.data.remote.repository.confirm.ConfirmRepositoryImpl
import com.example.stylescope.data.remote.repository.designer.DesignerRepositoryImpl
import com.example.stylescope.data.remote.repository.login.LogInRepositoryImpl
import com.example.stylescope.data.remote.repository.recover.RecoverRepositoryImpl
import com.example.stylescope.data.remote.repository.register.RegisterRepositoryImpl
import com.example.stylescope.domain.repository.changepassword.ChangePasswordRepository
import com.example.stylescope.domain.repository.company.CompanyRepository
import com.example.stylescope.domain.repository.confirm.ConfirmRepository
import com.example.stylescope.domain.repository.designer.DesignerRepository
import com.example.stylescope.domain.repository.login.LogInRepository
import com.example.stylescope.domain.repository.recover.RecoverRepository
import com.example.stylescope.domain.repository.register.RegisterRepository
import org.koin.dsl.module

val repoModule = module {
    single<CompanyRepository> { CompanyRepositoryImpl(get()) }
    single<DesignerRepository> { DesignerRepositoryImpl(get()) }
    single<LogInRepository> { LogInRepositoryImpl(get()) }
    single<RecoverRepository> { RecoverRepositoryImpl(get()) }
    single<RegisterRepository> { RegisterRepositoryImpl(get()) }
    single<ConfirmRepository> { ConfirmRepositoryImpl(get()) }
    single<ChangePasswordRepository> { ChangePasswordRepositoryImpl(get()) }
}