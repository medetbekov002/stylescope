package com.example.stylescope.presentation.ui.fragments.favorite.detail

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.favorite.FavoriteUseCase
import com.example.stylescope.presentation.model.favorite.FavoriteItemUI
import com.example.stylescope.presentation.model.favorite.toFavoriteItemUI
import kotlinx.coroutines.flow.asStateFlow

class FavoriteDetailViewModel(private val favoriteUseCase: FavoriteUseCase):BaseViewModel() {

    private val _state = mutableUIStateFlow<FavoriteItemUI>()
    val state = _state.asStateFlow()

    fun getFavorites(){
        favoriteUseCase().gatherRequest(_state){it.toFavoriteItemUI()}
    }

}