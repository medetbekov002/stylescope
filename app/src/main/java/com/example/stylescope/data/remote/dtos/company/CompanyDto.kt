package com.example.stylescope.data.remote.dtos.company

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.company.*
import com.google.gson.annotations.SerializedName

data class CompanyDto(
    val id: Int,
    val image: String?=null,
    val title: String?=null,
    val summary: String?=null,
    val views: Int?=null,
    val rating: String?=null,
    @SerializedName("count_reviews")
    val countReviews: String?=null,
    val services: List<ServicesDto>?=null,
    val packages: List<CompanyPackageDto>?=null
) : DataMapper<CompanyModel> {
    override fun toDomain() = CompanyModel(
        id = id,
        image = image,
        title = title,
        summary = summary,
        views = views,
        rating = rating,
        countReviews = countReviews,
        services = services!!.map { it.toDomain() },
        packages = packages!!.map { it.toDomain() }
    )
}

data class CompanyDetailDto(
    @SerializedName("site_link")
    val siteLink: String?=null,
    val image: String?=null,
    val title: String?=null,
    val summary: String?=null,
    val about: String?=null,
    val services: List<ServicesDto>?=null,
    val gallery: List<GalleryDto>?=null,
    val packages: List<CompanyPackageDto>?=null,
    val designers: List<CompanyDesignerDto>?=null,
    @SerializedName("count_reviews")
    val countReviews: String?=null,
    val reviews: List<CompanyReviewDto>?=null,
    @SerializedName("phone_number_1")
    val phoneNumber1: String?=null,
    @SerializedName("email_1")
    val email1: String?=null,
    @SerializedName("social_media_1")
    val socialMedia1: String?=null,
    val address: String?=null
) : DataMapper<CompanyDetailModel> {
    override fun toDomain() = CompanyDetailModel(
        siteLink = siteLink,
        image = image,
        title = title,
        summary = summary,
        about = about,
        services = services?.map { it.toDomain() },
        gallery = gallery?.map { it.toDomain() },
        packages = packages?.map { it.toDomain() },
        designers = designers?.map { it.toDomain() },
        countReviews = countReviews,
        reviews = reviews?.map { it.toDomain() },
        phoneNumber1 = phoneNumber1,
        email1 = email1,
        socialMedia1 = socialMedia1,
        address = address

    )
}

data class ServicesDto(
    val id: Int?=null,
    val title: String?=null,
    val description: String?=null
) : DataMapper<ServicesModel> {
    override fun toDomain() = ServicesModel(
        id = id,
        title = title,
        description = description
    )
}

data class CompanyReviewDto(
    val id: Int?=null,
    val rank: Int?=null,
    val company: CompanyReviewTitleDto,
    val text: String?=null,
    val user_photo: String?=null,
    val first_name: String? = null,
    val last_name: String? = null,
    val time_since_published: String?=null
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
    val title: String?=null,
    val image_url: String?=null
) : DataMapper<CompanyReviewTitleModel> {
    override fun toDomain() = CompanyReviewTitleModel(
        title = title,
        image_url = image_url
    )
}

data class GalleryDto(
    val id: Int?=null,
    val company: Int?=null,
    val image: String?=null,
) : DataMapper<GalleryModel> {
    override fun toDomain() = GalleryModel(
        id = id,
        company = company,
        image = image,
    )
}

data class CompanyPackageDto(
    val image: String?=null,
    val title: String?=null,
    val description: String?=null,
    val price: Int?=null
) : DataMapper<CompanyPackageModel> {
    override fun toDomain() = CompanyPackageModel(
        image = image,
        title = title,
        description = description,
        price = price
    )
}

data class CompanyDesignerDto(
    val photo: String?=null,
    val name: String?=null,
    @SerializedName("company_title")
    val companyTitle: List<String>?=null,
    val occupation: String?=null,
    val rating: String?=null,
    @SerializedName("count_reviews")
    val countReviews: String?=null
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
    data class CompanyFavoriteDto(
        @SerializedName("company_id")
        val companyId: Int
    )

    fun CompanyFavoriteModel.toData() = CompanyFavoriteDto(
        companyId = companyId
    )

