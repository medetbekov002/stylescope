package com.example.stylescope.presentation.model.company

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.company.*

data class CompanyUI(
    val id: Int?=null,
    val image: String?=null,
    val title: String?=null,
    val summary: String?=null,
    val views: Int?=null,
    val rating: String?=null,
    val countReviews: String?=null,
    val services: List<ServicesUI>?=null,
    val packages: List<CompanyPackageUI>?=null
)

fun CompanyModel.toUI() = CompanyUI(
    id = id,
    image = image,
    title = title,
    summary = summary,
    views = views,
    rating = rating,
    countReviews = countReviews,
    services = services!!.map { it.toUI() },
    packages = packages!!.map { it.toUI() }
)

data class CompanyDetailUI(
    val siteLink: String?=null,
    val image: String?=null,
    val title: String?=null,
    val summary: String?=null,
    val about: String?=null,
    val services: List<ServicesUI>?=null,
    val gallery: List<GalleryUI>?=null,
    val packages: List<CompanyPackageUI>?=null,
    val designers: List<CompanyDesignerUI>?=null,
    val countReviews: String?=null,
    val reviews: List<CompanyReviewUI>?=null,
    val phoneNumber1: String?=null,
    val email1: String?=null,
    val socialMedia1: String?=null,
    val address: String?=null
)

fun CompanyDetailModel.toUI() = CompanyDetailUI(
    siteLink = siteLink,
    image = image,
    title = title,
    summary = summary,
    about = about,
    services = services?.map { it.toUI() },
    gallery = gallery?.map { it.toUI() },
    packages = packages?.map { it.toUI() },
    designers = designers?.map { it.toUI() },
    countReviews = countReviews,
    reviews = reviews?.map { it.toUI() },
    phoneNumber1 = phoneNumber1,
    email1 = email1,
    socialMedia1 = socialMedia1,
    address = address
)

data class CompanyReviewUI(
    val id: Int?=null,
    val rank: Int?=null,
    val company: CompanyReviewTitleUI?=null,
    val text: String?=null,
    val user_photo: String?=null,
    val first_name:String?=null,
    val last_name:String?=null,
    val username: String?=null,
    val time_since_published: String?=null
)

fun CompanyReviewModel.toUI() = CompanyReviewUI(
    id = id,
    rank = rank,
    company = company?.toUI(),
    text = text,
    user_photo = user_photo,
    username = username,
    first_name = first_name,
    last_name = last_name,
    time_since_published = time_since_published
)


data class CompanyReviewTitleUI(
    val title: String?=null,
    val image_url: String?=null
)

fun CompanyReviewTitleModel.toUI() = CompanyReviewTitleUI(
    title = title,
    image_url = image_url
)


data class ServicesUI(
    val id: Int?=null,
    val title: String?=null,
    val description: String?=null
)

fun ServicesModel.toUI() = ServicesUI(
    id, title, description
)

data class GalleryUI(
    val id: Int?=null,
    val company: Int?=null,
    val image: String?=null,
)

fun GalleryModel.toUI() = GalleryUI(
    id, company, image
)

data class CompanyPackageUI(
    val image: String?=null,
    val title: String?=null,
    val description: String?=null,
    val price: Int?=null
)

fun CompanyPackageModel.toUI() = CompanyPackageUI(
    image = image,
    title = title,
    description = description,
    price = price
)

data class CompanyDesignerUI(
    val photo: String?=null,
    val name: String?=null,
    val companyTitle: List<String>?=null,
    val occupation: String?=null,
    val rating: String?=null,
    val countReviews: String?=null
)

fun CompanyDesignerModel.toUI() = CompanyDesignerUI(
    photo = photo,
    name = name,
    companyTitle = companyTitle,
    occupation = occupation,
    rating = rating,
    countReviews = countReviews
)

data class CompanyFavoriteUI(
    val companyId: Int
): DataMapper<CompanyFavoriteModel> {
    override fun toDomain() = CompanyFavoriteModel(
        companyId = companyId
    )
}

