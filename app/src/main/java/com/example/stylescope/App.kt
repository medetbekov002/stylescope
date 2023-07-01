package com.example.stylescope

import android.app.Application
import com.example.stylescope.data.remote.module.repoModule
import com.example.stylescope.data.remote.module.retrofitModule
import com.example.stylescope.domain.module.useCasesModule
import com.example.stylescope.presentation.module.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(retrofitModule, repoModule, useCasesModule, uiModule)
        }
    }
}