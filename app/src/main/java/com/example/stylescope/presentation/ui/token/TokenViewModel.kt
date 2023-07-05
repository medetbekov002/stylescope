package com.example.stylescope.presentation.ui.token

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.token.TokenUseCase
import com.example.stylescope.presentation.model.token.*
import kotlinx.coroutines.flow.asStateFlow

class TokenViewModel(private val tokenUseCase: TokenUseCase):BaseViewModel() {

    private val _getTokenState= mutableUIStateFlow<GetTokenAnswerUI>()
    val getTokenState = _getTokenState.asStateFlow()

    private val _refreshTokenState = mutableUIStateFlow<RefreshTokenAnswerUI>()
    val refreshTokenState = _refreshTokenState.asStateFlow()

    private val _verifyTokenState = mutableUIStateFlow<VerifyTokenAnswerUI>()
    val verifyTokenState = _verifyTokenState.asStateFlow()

    fun getToken(body:GetTokenUI){
        tokenUseCase.getToken(body.toGetTokenModel()).gatherRequest(_getTokenState){it.toGetTokenAnswerUI()}
    }

    fun refreshToken(body:RefreshTokenUI){
        tokenUseCase.refreshToken(body.toRefreshTokenModel()).gatherRequest(_refreshTokenState){it.toRefreshTokenAnswerUI()}
    }

    fun verifyToken(body:VerifyTokenUI){
        tokenUseCase.verifyToken(body.toVerifyTokenModel()).gatherRequest(_verifyTokenState){it.toVerifyTokenAnswerUI()}
    }

}