package com.example.stylescope.domain.repository.token

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.*
import kotlinx.coroutines.flow.Flow

interface TokenRepository {

    fun getToken(body:GetTokenModel):Flow<Either<String,GetTokenAnswerModel>>

    fun refreshToken(body:RefreshTokenModel):Flow<Either<String,RefreshTokenAnswerModel>>

    fun verifyToken(body:VerifyTokenModel):Flow<Either<String,VerifyTokenAnswerModel>>



}