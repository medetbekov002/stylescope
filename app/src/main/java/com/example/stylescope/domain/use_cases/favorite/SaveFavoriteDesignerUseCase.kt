package com.example.stylescope.domain.use_cases.favorite

import com.example.stylescope.domain.model.designer.DesignerFavoriteModel
import com.example.stylescope.domain.repository.favorite.SaveFavoriteDesignerRepository

class SaveFavoriteDesignerUseCase(private val repository: SaveFavoriteDesignerRepository) {

    operator fun invoke(model: DesignerFavoriteModel, id: String) =
        repository.saveFavoriteDesigner(model = model, id = id)

}