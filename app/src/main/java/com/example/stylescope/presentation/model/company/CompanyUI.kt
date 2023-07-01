package com.example.stylescope.presentation.model.company

import com.example.stylescope.domain.model.company.CompanyDesignerModel
import com.example.stylescope.domain.model.company.CompanyDetailModel
import com.example.stylescope.domain.model.company.CompanyModel
import com.example.stylescope.domain.model.company.CompanyPackageModel
import com.example.stylescope.domain.model.company.GalleryModel
import com.example.stylescope.domain.model.company.ServicesModel

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
    val reviews: List<Int>,
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
    countReviews,
    reviews,
    phoneNumber1,
    email1,
    socialMedia1,
    address
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
    val about: String
)

fun GalleryModel.toUI() = GalleryUI(
    id, company, image, about
)

data class CompanyPackageUI(
    val image: String,
    val title: String,
    val description: String,
    val price: Int
)

fun CompanyPackageModel.toUI() = CompanyPackageUI(
    image = image,
    title = title,
    description = description,
    price = price
)
data class CompanyDesignerUI(
    val photo: String,
    val name: String,
    val companyTitle: List<String>,
    val occupation: String,
    val rating: String,
    val countReviews: String
)

fun CompanyDesignerModel.toUI() = CompanyDesignerUI(
    photo = photo,
    name = name,
    companyTitle = companyTitle,
    occupation = occupation,
    rating = rating,
    countReviews = countReviews
)
