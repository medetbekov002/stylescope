package com.example.stylescope.data.remote.repository.login

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.mapper.toLoginDto
import com.example.stylescope.data.remote.dtos.login.LoginAnswerDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.login.LogInAnswerModel
import com.example.stylescope.domain.model.login.LoginModel
import com.example.stylescope.domain.repository.login.LogInRepository
import kotlinx.coroutines.flow.Flow

class LogInRepositoryImpl(private val api: ApiService) : LogInRepository {
    override fun logIn(body: LoginModel): Flow<Either<String, LogInAnswerModel>> = makeNetworkRequest {
        api.logIn(body.toLoginDto()).toDomain()
    }
}