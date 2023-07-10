package com.example.stylescope.domain.model.designer

data class DesignerModel(
    val id: Int? = null,
    val name: String? = null,
    val photo: String? = null,
    val occupation: String? = null,
    val rating: String? = null,
    val countReviews: String? = null
)

data class DesignerDetailModel(
    val name: String? = null,
    val surname: String? = null,
    val photo: String? = null,
    val workEXP: String? = null,
    val occupation: String? = null,
    val description: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val instagram: String? = null,
    val gallery: List<DesignerGalleryModel>? = null,
    val rating: String? = null,
    val countReviews: String? = null,
    val reviews: List<DesignReviewModel>? = null
)

data class DesignerGalleryModel(
    val about: String? = null,
    val image: String? = null
)

data class DesignReviewModel(
    val id: Int? = null,
    val rank: Int? = null,
    val text: String? = null,
    val user_photo: String? = null,
    val designer: RVDesignerModel? = null,
    val username: String? = null,
    val time_since_published: String? = null
) {
    data class RVDesignerModel(
        val name: String? = null,
        val photo_url: String? = null
    )
}


data class DesignerFavoriteModel(
    val designerId: Int
)
