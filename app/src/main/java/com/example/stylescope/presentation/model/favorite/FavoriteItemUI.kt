package com.example.stylescope.presentation.model.favorite

import com.example.stylescope.domain.model.favorite.FavoriteItemModel
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.model.company.toUI
import com.example.stylescope.presentation.model.designer.DesignerUI
import com.example.stylescope.presentation.model.designer.toUI

data class FavoriteItemUI(
    val companies: List<CompanyUI>?=null,
    val designers:List<DesignerUI>?=null
)

fun FavoriteItemModel.toFavoriteItemUI() = FavoriteItemUI(companies?.map { it.toUI() },designers?.map { it.toUI() })

