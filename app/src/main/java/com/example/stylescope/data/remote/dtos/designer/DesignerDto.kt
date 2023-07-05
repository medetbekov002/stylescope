package com.example.stylescope.data.remote.dtos.designer

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.designer.DesignReviewModel
import com.example.stylescope.domain.model.designer.DesignerDetailModel
import com.example.stylescope.domain.model.designer.DesignerGalleryModel
import com.example.stylescope.domain.model.designer.DesignerModel
import com.google.gson.annotations.SerializedName

data class DesignerDto(
    val id: Int,
    val name: String,
    val photo: String,
    @SerializedName("company_title")
    val companyTitle: List<String>,
    val occupation: String,
    val rating: String,
    @SerializedName("count_reviews")
    val countReviews: String
) : DataMapper<DesignerModel> {
    override fun toDomain() = DesignerModel(
        id = id,
        name = name,
        photo = photo,
        companyTitle = companyTitle,
        occupation = occupation,
        rating = rating,
        countReviews = countReviews
    )
}

data class DesignerDetailDto(
    val name: String,
    val surname: String,
    val photo: String,
    @SerializedName("work_EXP")
    val workEXP: String,
    val occupation: String,
    val description: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    val email: String,
    val instagram: String,
    val gallery: List<DesignerGalleryDto>,
    val rating: String,
    @SerializedName("count_reviews")
    val countReviews: String,
    val reviews: List<DesignReviewDtp>
) : DataMapper<DesignerDetailModel> {
    override fun toDomain() = DesignerDetailModel(
        name = name,
        surname = surname,
        photo = photo,
        workEXP = workEXP,
        occupation = occupation,
        description = description,
        phoneNumber = phoneNumber,
        email = email,
        instagram = instagram,
        gallery = gallery.map { it.toDomain() },
        rating = rating,
        countReviews = countReviews,
        reviews = reviews.map { it.toDomain() }
    )
}

data class DesignerGalleryDto(
    val about: String,
    val image: String
) : DataMapper<DesignerGalleryModel> {
    override fun toDomain() = DesignerGalleryModel(
        about = about,
        image = image
    )
}

data class DesignReviewDtp(
    val id: Int,
    val rank: Int,
    val text: String,
    val user_photo: String,
    val designer: RVDesignerDto,
    val username: String,
    val time_since_published: String
) : DataMapper<DesignReviewModel> {
    override fun toDomain() = DesignReviewModel(
        id = id,
        rank = rank,
        text = text,
        user_photo = user_photo,
        designer = designer.toDomain(),
        username = username,
        time_since_published = time_since_published
    )
}

data class RVDesignerDto(
    val name: String,
    val photo_url: String
) : DataMapper<DesignReviewModel.RVDesignerModel> {
    override fun toDomain() = DesignReviewModel.RVDesignerModel (
        name = name,
        photo_url = photo_url
    )
}
