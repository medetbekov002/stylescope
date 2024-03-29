package com.example.stylescope.domain.model.favorite

import com.example.stylescope.domain.model.company.CompanyModel
import com.example.stylescope.domain.model.designer.DesignerModel

data class FavoriteItemModel(
    val companies: CompanyModel?=null,
    val designers: DesignerModel?=null
)
