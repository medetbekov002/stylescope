package com.example.stylescope.di

import com.example.stylescope.core.network.networkModule
import com.example.stylescope.data.remote.remoteDataSource
import org.koin.core.module.Module

val koinModules = listOf<Module>(
    repoModules,
    viewModules,
    remoteDataSource,
    networkModule
)