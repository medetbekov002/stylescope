package com.example.stylescope.data.remote.dtos.designer

data class DesignerDetailDto2(
    val name: String?,
    val surname: String?,
    val photo: String?,
    val work_EXP: String?,
    val occupation: String?,
    val description: String?,
    val phone_number: String?,
    val email: String?,
    val instagram: String?,
    val gallery: List<Gallery?>?,
    val rating: Double?,
    val count_reviews: Int?,
    val reviews: List<Review?>?
) {
    data class Gallery(
        val about: String?,
        val image: String?
    )

    data class Review(
        val id: Int?,
        val rank: Int?,
        val text: String?,
        val user_photo: String?,
        val designer: Designer?,
        val username: String?,
        val time_since_published: String?
    ) {
        data class Designer(
            val name: String?,
            val photo_url: String?
        )
    }
}