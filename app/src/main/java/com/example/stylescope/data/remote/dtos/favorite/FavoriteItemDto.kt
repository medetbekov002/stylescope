package com.example.stylescope.data.remote.dtos.favorite

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.data.remote.dtos.company.CompanyDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDto
import com.example.stylescope.domain.model.favorite.FavoriteItemModel

data class FavoriteItemDto(
    val companies: List<CompanyDto>?=null,
    val designers:List<DesignerDto>?=null
):DataMapper<FavoriteItemModel> {
    override fun toDomain()=FavoriteItemModel(companies?.map { it.toDomain()},designers?.map { it.toDomain() })
}
