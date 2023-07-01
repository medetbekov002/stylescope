package com.example.stylescope.domain.model.designer

data class DesignerModel(
    val id: Int,
    val name: String,
    val photo: String,
    val companyTitle: List<String>,
    val occupation: String,
    val rating: String,
    val countReviews: String
)

data class DesignerDetailModel(
    val name:String,
    val surname:String,
    val photo:String,
    val workEXP:String,
    val occupation:String,
    val description:String,
    val phoneNumber:String,
    val email:String,
    val instagram:String,
    val gallery:List<DesignerGalleryModel>,
    val rating:String,
    val countReviews:String
)

data class DesignerGalleryModel(
    val about:String,
    val image:String
)