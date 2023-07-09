package com.example.stylescope.data.remote.dtos.company

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.company.*
import com.google.gson.annotations.SerializedName

data class CompanyDto(
    val id: Int,
    val image: String,
    val title: String,
    val summary: String,
    val views: Int,
    val rating: String,
    @SerializedName("count_reviews")
    val countReviews: String
) : DataMapper<CompanyModel> {
    override fun toDomain() = CompanyModel(
        id = id,
        image = image,
        title = title,
        summary = summary,
        views = views,
        rating = rating,
        countReviews = countReviews
    )
}

data class CompanyDetailDto(
    @SerializedName("site_link")
    val siteLink: String,
    val image: String,
    val title: String,
    val summary: String,
    val about: String,
    val services: List<ServicesDto>,
    val gallery: List<GalleryDto>,
    val packages: List<CompanyPackageDto>,
    val designers: List<CompanyDesignerDto>,
    @SerializedName("count_reviews")
    val countReviews: String,
    val reviews: List<CompanyReviewDto>,
    @SerializedName("phone_number_1")
    val phoneNumber1: String,
    @SerializedName("email_1")
    val email1: String,
    @SerializedName("social_media_1")
    val socialMedia1: String,
    val address: String
) : DataMapper<CompanyDetailModel> {
    override fun toDomain() = CompanyDetailModel(
        siteLink = siteLink,
        image = image,
        title = title,
        summary = summary,
        about = about,
        services = services.map { it.toDomain() },
        gallery = gallery.map { it.toDomain() },
        packages = packages.map { it.toDomain() },
        designers = designers.map { it.toDomain() },
        countReviews = countReviews,
        reviews = reviews.map { it.toDomain() },
        phoneNumber1 = phoneNumber1,
        email1 = email1,
        socialMedia1 = socialMedia1,
        address = address

    )
}

data class ServicesDto(
    val id: Int,
    val title: String,
    val description: String
) : DataMapper<ServicesModel> {
    override fun toDomain() = ServicesModel(
        id = id,
        title = title,
        description = description
    )
}

data class CompanyReviewDto(
    val id: Int,
    val rank: Int,
    val company: CompanyReviewTitleDto,
    val text: String,
    val user_photo: String,
    val username: String,
    val first_name: String? = null,
    val last_name: String? = null,
    val time_since_published: String
) : DataMapper<CompanyReviewModel> {
    override fun toDomain() = CompanyReviewModel(
        id = id,
        rank = rank,
        company = company.toDomain(),
        text = text,
        user_photo = user_photo,
        username = username,
        first_name = first_name,
        last_name = last_name,
        time_since_published = time_since_published
    )
}

data class CompanyReviewTitleDto(
    val title: String,
    val image_url: String
) : DataMapper<CompanyReviewTitleModel> {
    override fun toDomain() = CompanyReviewTitleModel(
        title = title,
        image_url = image_url
    )
}

data class GalleryDto(
    val id: Int,
    val company: Int,
    val image: String,
    val about: String
) : DataMapper<GalleryModel> {
    override fun toDomain() = GalleryModel(
        id = id,
        company = company,
        image = image,
        about = about
    )
}

data class CompanyPackageDto(
    val image: String,
    val title: String,
    val description: String,
    val price: Int
) : DataMapper<CompanyPackageModel> {
    override fun toDomain() = CompanyPackageModel(
        image = image,
        title = title,
        description = description,
        price = price
    )
}

data class CompanyDesignerDto(
    val photo: String,
    val name: String,
    @SerializedName("company_title")
    val companyTitle: List<String>,
    val occupation: String,
    val rating: String,
    @SerializedName("count_reviews")
    val countReviews: String
) : DataMapper<CompanyDesignerModel> {
    override fun toDomain() = CompanyDesignerModel(
        photo = photo,
        name = name,
        companyTitle = companyTitle,
        occupation = occupation,
        rating = rating,
        countReviews = countReviews
    )
}

