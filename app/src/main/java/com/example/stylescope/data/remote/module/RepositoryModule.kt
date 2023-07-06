package com.example.stylescope.data.remote.module

import com.example.stylescope.data.remote.repository.company.CompanyRepositoryImpl
import com.example.stylescope.data.remote.repository.designer.DesignerRepositoryImpl
import com.example.stylescope.data.remote.repository.user.profile.UpdateUserImageRepositoryImpl
import com.example.stylescope.data.remote.repository.user.profile.UpdateUserProfileRepositoryImpl
import com.example.stylescope.data.remote.repository.user.profile.UserProfileRepositoryImpl
import com.example.stylescope.domain.repository.company.CompanyRepository
import com.example.stylescope.domain.repository.designer.DesignerRepository
import com.example.stylescope.domain.repository.user.profile.UpdateUserImageRepository
import com.example.stylescope.domain.repository.user.profile.UpdateUserProfileRepository
import com.example.stylescope.domain.repository.user.profile.UserProfileRepository
import org.koin.dsl.module

val repoModule = module {
    single<CompanyRepository> { CompanyRepositoryImpl(get()) }
    single<DesignerRepository> { DesignerRepositoryImpl(get()) }
    single<UserProfileRepository> { UserProfileRepositoryImpl(get()) }
    single<UpdateUserProfileRepository> { UpdateUserProfileRepositoryImpl(get()) }
    single<UpdateUserImageRepository> { UpdateUserImageRepositoryImpl(get()) }
}