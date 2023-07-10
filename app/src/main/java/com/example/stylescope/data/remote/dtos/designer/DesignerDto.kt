package com.example.stylescope.data.remote.dtos.designer

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.designer.DesignReviewModel
import com.example.stylescope.domain.model.designer.DesignerDetailModel
import com.example.stylescope.domain.model.designer.DesignerFavoriteModel
import com.example.stylescope.domain.model.designer.DesignerGalleryModel
import com.example.stylescope.domain.model.designer.DesignerModel
import com.google.gson.annotations.SerializedName

data class DesignerDto(
    val id: Int? = null,
    val name: String? = null,
    val photo: String? = null,
    val occupation: String? = null,
    val rating: Double? = null,
    val surname: String? = null,
    @SerializedName("count_reviews")
    val countReviews: Int? = null
) : DataMapper<DesignerModel> {
    override fun toDomain() = DesignerModel(
        id = id,
        name = name,
        photo = photo,
        occupation = occupation,
        rating = rating,
        countReviews = countReviews,
        surname = surname
    )
}

data class DesignerDetailDto(
    val name: String? = null,
    val surname: String? = null,
    val photo: String? = null,
    @SerializedName("work_EXP")
    val workEXP: String? = null,
    val occupation: String? = null,
    val description: String? = null,
    @SerializedName("phone_number")
    val phoneNumber: String? = null,
    val email: String? = null,
    val instagram: String? = null,
    val gallery: List<DesignerGalleryDto>? = null,
    val rating: String? = null,
    @SerializedName("count_reviews")
    val countReviews: String? = null,
    val reviews: List<DesignReviewDtp>? = null
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
        gallery = gallery?.map { it.toDomain() },
        rating = rating,
        countReviews = countReviews,
        reviews = reviews?.map { it.toDomain() }
    )
}

data class DesignerGalleryDto(
    val about: String? = null,
    val image: String? = null
) : DataMapper<DesignerGalleryModel> {
    override fun toDomain() = DesignerGalleryModel(
        about = about,
        image = image
    )
}

data class DesignReviewDtp(
    val id: Int? = null,
    val rank: Int? = null,
    val text: String? = null,
    val user_photo: String? = null,
    val designer: RVDesignerDto? = null,
    val username: String? = null,
    val time_since_published: String? = null
) : DataMapper<DesignReviewModel> {
    override fun toDomain() = DesignReviewModel(
        id = id,
        rank = rank,
        text = text,
        user_photo = user_photo,
        designer = designer?.toDomain(),
        username = username,
        time_since_published = time_since_published
    )
}

data class RVDesignerDto(
    val name: String? = null,
    val photo_url: String? = null
) : DataMapper<DesignReviewModel.RVDesignerModel> {
    override fun toDomain() = DesignReviewModel.RVDesignerModel (
        name = name,
        photo_url = photo_url
    )
}

data class DesignerFavoriteDto(
    @SerializedName("designer_id")
    val designerId: Int
)

fun DesignerFavoriteModel.toData() = DesignerFavoriteDto(
    designerId = designerId
)
