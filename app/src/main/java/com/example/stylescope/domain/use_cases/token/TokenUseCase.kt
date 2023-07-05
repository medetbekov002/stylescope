package com.example.stylescope.domain.use_cases.token

import com.example.stylescope.domain.model.GetTokenModel
import com.example.stylescope.domain.model.RefreshTokenModel
import com.example.stylescope.domain.model.VerifyTokenModel
import com.example.stylescope.domain.repository.token.TokenRepository

class TokenUseCase(private val repository: TokenRepository) {

    fun getToken(body:GetTokenModel) = repository.getToken(body)

    fun refreshToken(body:RefreshTokenModel) = repository.refreshToken(body)

    fun verifyToken(body:VerifyTokenModel) = repository.verifyToken(body)

}