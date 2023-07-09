package com.example.stylescope.domain.model.myreviews

import com.example.stylescope.domain.model.company.CompanyReviewModel

data class MyReviewsModel(
    val total_reviews:Int?=null,
    val company_reviews:List<CompanyReviewModel>?=null,
    val designer_reviews:List<DesignerReviewModel>?=null
)

data class DesignerReviewModel(
    val id: Int?=null,
    val rank: Int?=null,
    val company: DesignerReviewTitleModel?=null,
    val text: String?=null,
    val user_photo: String?=null,
    val username: String?=null,
    val first_name:String?=null,
    val last_name:String?=null,
    val time_since_published: String?=null
)

data class DesignerReviewTitleModel(
    val name:String?=null,
    val photo_url:String?=null
)