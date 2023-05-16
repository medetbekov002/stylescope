package com.example.stylescope.di

import com.example.stylescope.repository.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get()) }
}

