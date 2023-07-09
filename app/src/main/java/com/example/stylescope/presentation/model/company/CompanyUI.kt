package com.example.stylescope.presentation.model.company

import com.example.stylescope.domain.model.company.*

data class CompanyUI(
    val id: Int,
    val image: String,
    val title: String,
    val summary: String,
    val views: Int,
    val rating: String,
    val countReviews: String
)

fun CompanyModel.toUI() = CompanyUI(
    id = id,
    image = image,
    title = title,
    summary = summary,
    views = views,
    rating = rating,
    countReviews = countReviews
)

data class CompanyDetailUI(
    val siteLink: String,
    val image: String,
    val title: String,
    val summary: String,
    val about: String,
    val services: List<ServicesUI>,
    val gallery: List<GalleryUI>,
    val packages: List<CompanyPackageUI>,
    val designers: List<CompanyDesignerUI>,
    val countReviews: String,
    val phoneNumber1: String,
    val email1: String,
    val socialMedia1: String,
    val address: String
)

fun CompanyDetailModel.toUI() = CompanyDetailUI(
    siteLink = siteLink,
    image = image,
    title = title,
    summary = summary,
    about = about,
    services = services.map { it.toUI() },
    gallery = gallery.map { it.toUI() },
    packages = packages.map { it.toUI() },
    designers = designers.map { it.toUI() },
    countReviews = countReviews,
    phoneNumber1 = phoneNumber1,
    email1 = email1,
    socialMedia1 = socialMedia1,
    address = address
)

data class CompanyReviewUI(
    val id: Int,
    val rank: Int,
    val company: CompanyReviewTitleUI,
    val text: String,
    val user_photo: String,
    val username: String,
    val first_name:String?=null,
    val last_name:String?=null,
    val time_since_published: String
)

fun CompanyReviewModel.toUI() = CompanyReviewUI(
    id = id,
    rank = rank,
    company = company.toUI(),
    text = text,
    user_photo = user_photo,
    username = username,
    first_name = first_name,
    last_name = last_name,
    time_since_published = time_since_published
)


data class CompanyReviewTitleUI(
    val title: String,
    val image_url: String
)

fun CompanyReviewTitleModel.toUI() = CompanyReviewTitleUI(
    title = title,
    image_url = image_url
)


data class ServicesUI(
    val id: Int,
    val title: String,
    val description: String
)

fun ServicesModel.toUI() = ServicesUI(
    id, title, description
)

data class GalleryUI(
    val id: Int,
    val company: Int,
    val image: String,
)

fun GalleryModel.toUI() = GalleryUI(
    id, company, image
)

data class CompanyPackageUI(
    val title: String,
    val description: String,
    val price: Int
)

fun CompanyPackageModel.toUI() = CompanyPackageUI(
    title = title,
    description = description,
    price = price
)

data class CompanyDesignerUI(
    val id: Int,
    val photo: String,
    val name: String,
    val occupation: String,
    val rating: String,
    val countReviews: String
)

fun CompanyDesignerModel.toUI() = CompanyDesignerUI(
    id = id,
    photo = photo,
    name = name,
    occupation = occupation,
    rating = rating,
    countReviews = countReviews
)
