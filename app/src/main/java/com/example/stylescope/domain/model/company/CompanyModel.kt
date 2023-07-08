package com.example.stylescope.domain.model.company


data class CompanyModel(
    val id: Int?=null,
    val image: String?=null,
    val title: String?=null,
    val summary: String?=null,
    val views: Int?=null,
    val rating: String?=null,
    val countReviews: String?=null
)

data class CompanyDetailModel(
    val siteLink: String?=null,
    val image: String?=null,
    val title: String?=null,
    val summary: String?=null,
    val about: String?=null,
    val services: List<ServicesModel>?=null,
    val gallery: List<GalleryModel>?=null,
    val packages: List<CompanyPackageModel>?=null,
    val designers: List<CompanyDesignerModel>?=null,
    val countReviews: String?=null,
    val reviews: List<CompanyReviewModel>?=null,
    val phoneNumber1: String?=null,
    val email1: String?=null,
    val socialMedia1: String?=null,
    val address: String?=null
)

data class ServicesModel(
    val id: Int?=null,
    val title: String?=null,
    val description: String?=null
)

data class GalleryModel(
    val id: Int?=null,
    val company: Int?=null,
    val image: String?=null,
)

data class CompanyPackageModel(
    val image: String?=null,
    val title: String?=null,
    val description: String?=null,
    val price: Int?=null
)

data class CompanyDesignerModel(
    val photo: String?=null,
    val name: String?=null,
    val companyTitle: List<String>?=null,
    val occupation: String?=null,
    val rating: String?=null,
    val countReviews: String?=null
)
data class CompanyReviewModel(
    val id: Int?=null,
    val rank: Int?=null,
    val company: CompanyReviewTitleModel?=null,
    val text: String?=null,
    val user_photo: String?=null,
    val username: String?=null,
    val time_since_published: String?=null
)
data class CompanyReviewTitleModel(
    val title: String?=null,
    val image_url: String?=null
)


