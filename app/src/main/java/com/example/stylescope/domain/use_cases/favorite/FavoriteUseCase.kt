package com.example.stylescope.domain.use_cases.favorite

import com.example.stylescope.domain.repository.favorite.FavoriteRepository

class FavoriteUseCase(private val repository: FavoriteRepository) {

    operator fun invoke() = repository.getFavorites()

}