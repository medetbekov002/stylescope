package com.example.stylescope.data.remote

import com.example.stylescope.core.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}
class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {

}