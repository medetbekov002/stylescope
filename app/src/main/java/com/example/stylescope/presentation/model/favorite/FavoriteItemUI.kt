package com.example.stylescope.presentation.model.favorite

import com.example.stylescope.domain.model.favorite.FavoriteItemModel
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.model.company.toUI
import com.example.stylescope.presentation.model.designer.DesignerUI
import com.example.stylescope.presentation.model.designer.toUI

data class FavoriteItemUI(
    val companies: CompanyUI?=null,
    val designers: DesignerUI?=null
)

fun FavoriteItemModel.toFavoriteItemUI() = FavoriteItemUI(companies?.toUI(), designers?.toUI())

