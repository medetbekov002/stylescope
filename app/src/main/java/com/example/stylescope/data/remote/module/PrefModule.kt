package com.example.stylescope.data.remote.module

import com.example.stylescope.data.local.Pref
import org.koin.dsl.module

val prefModule = module {
    single{Pref(get())}
}