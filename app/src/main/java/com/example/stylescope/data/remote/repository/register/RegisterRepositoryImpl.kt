package com.example.stylescope.data.remote.repository.register

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.login.toRegisterDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.login.RegisterModel
import com.example.stylescope.domain.repository.register.RegisterRepository
import kotlinx.coroutines.flow.Flow

class RegisterRepositoryImpl(private val apiService: ApiService):RegisterRepository {

    override fun register(body: RegisterModel): Flow<Either<String, List<String>>> = makeNetworkRequest{
        apiService.register(body.toRegisterDto())
    }
}