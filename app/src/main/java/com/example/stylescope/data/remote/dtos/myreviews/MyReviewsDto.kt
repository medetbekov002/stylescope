package com.example.stylescope.data.remote.dtos.myreviews

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.data.remote.dtos.company.CompanyReviewDto
import com.example.stylescope.domain.model.myreviews.DesignerReviewModel
import com.example.stylescope.domain.model.myreviews.DesignerReviewTitleModel
import com.example.stylescope.domain.model.myreviews.MyReviewsModel


data class MyReviewsDto(
    val total_reviews:Int?=null,
    val company_reviews:List<CompanyReviewDto>?=null,
    val designer_reviews:List<DesignerReviewDto>?=null
):DataMapper<MyReviewsModel> {
    override fun toDomain()= MyReviewsModel(
        total_reviews,
        company_reviews?.map { it.toDomain() },
        designer_reviews?.map { it.toDomain() }
    )
}

data class DesignerReviewDto(
    val id: Int?=null,
    val rank: Int?=null,
    val company: DesignerReviewTitleDto?=null,
    val text: String?=null,
    val user_photo: String?=null,
    val username: String?=null,
    val first_name:String?=null,
    val last_name:String?=null,
    val time_since_published: String
) : DataMapper<DesignerReviewModel> {
    override fun toDomain() = DesignerReviewModel(
        id = id,
        rank = rank,
        company = company?.toDomain(),
        text = text,
        user_photo = user_photo,
        username = username,
        first_name = first_name,
        last_name = last_name,
        time_since_published = time_since_published
    )
}

data class DesignerReviewTitleDto(
    val name:String?=null,
    val photo_url:String?=null
):DataMapper<DesignerReviewTitleModel> {
    override fun toDomain()=DesignerReviewTitleModel(
        name,photo_url
    )
}
