package com.example.stylescope.data.remote.dtos.favorite

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.data.remote.dtos.company.CompanyDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDto
import com.example.stylescope.domain.model.favorite.FavoriteItemModel

data class FavoriteItemDto(
    val companies: CompanyDto?=null,
    val designers: DesignerDto?=null
):DataMapper<FavoriteItemModel> {
    override fun toDomain()=FavoriteItemModel(companies?.toDomain() ,designers?.toDomain())
}
