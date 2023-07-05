package com.example.stylescope.presentation

import android.app.Application
import com.example.stylescope.data.remote.module.prefModule
import com.example.stylescope.data.remote.module.repoModule
import com.example.stylescope.data.remote.module.retrofitModule
import com.example.stylescope.domain.module.useCasesModule
import com.example.stylescope.presentation.module.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StyleScopeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StyleScopeApp)
            modules(retrofitModule, repoModule, useCasesModule, uiModule, prefModule)
        }
    }
}