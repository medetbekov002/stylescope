package com.example.stylescope.data.remote.repository.token

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.token.toGetTokenDto
import com.example.stylescope.data.remote.dtos.token.toRefreshTokenDto
import com.example.stylescope.data.remote.dtos.token.toVerifyTokenDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.*
import com.example.stylescope.domain.repository.token.TokenRepository
import kotlinx.coroutines.flow.Flow

class TokenRepositoryImpl(private val apiService: ApiService) : TokenRepository {
    override fun getToken(body: GetTokenModel): Flow<Either<String, GetTokenAnswerModel>> =
        makeNetworkRequest {
            apiService.getToken(body.toGetTokenDto()).toDomain()
        }

    override fun refreshToken(body: RefreshTokenModel): Flow<Either<String, RefreshTokenAnswerModel>> =
        makeNetworkRequest {
            apiService.refreshToken(body.toRefreshTokenDto()).toDomain()
        }

    override fun verifyToken(body: VerifyTokenModel): Flow<Either<String, VerifyTokenAnswerModel>> =
        makeNetworkRequest {
            apiService.verifyToken(body.toVerifyTokenDto()).toDomain()
        }


}