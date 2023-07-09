package com.example.stylescope.presentation.model.myreviews

import com.example.stylescope.domain.model.myreviews.DesignerReviewModel
import com.example.stylescope.domain.model.myreviews.DesignerReviewTitleModel
import com.example.stylescope.domain.model.myreviews.MyReviewsModel
import com.example.stylescope.presentation.model.company.CompanyReviewUI
import com.example.stylescope.presentation.model.company.toUI

data class MyReviewsUI(
    val total_reviews:Int?=null,
    val company_reviews:List<CompanyReviewUI>?=null,
    val designer_reviews:List<DesignerReviewUI>?=null
)

fun MyReviewsModel.toMyReviewsUI() = MyReviewsUI(
    total_reviews,
    company_reviews?.map { it.toUI() },
    designer_reviews?.map { it.toDesignerReviewUI() }
)

data class DesignerReviewUI(
    val id: Int?=null,
    val rank: Int?=null,
    val company: DesignerReviewTitleUI?=null,
    val text: String?=null,
    val user_photo: String?=null,
    val username: String?=null,
    val first_name:String?=null,
    val last_name:String?=null,
    val time_since_published: String?=null
)

fun DesignerReviewModel.toDesignerReviewUI() = DesignerReviewUI(
    id,
    rank,
    company?.toDesignerReviewTitleUI(),
    text,
    user_photo,
    username,
    first_name,
    last_name,
    time_since_published
)

data class DesignerReviewTitleUI(
    val name:String?=null,
    val photo_url:String?=null
)

fun DesignerReviewTitleModel.toDesignerReviewTitleUI() = DesignerReviewTitleUI(
    name,photo_url
)