package com.example.stylescope.data.remote.dtos.company

data class CompanyDto2(
    val site_link: String?,
    val image: String?,
    val title: String?,
    val summary: String?,
    val about: String?,
    val services: List<Service?>?,
    val gallery: List<Gallery?>?,
    val packages: List<Package?>?,
    val designers: List<Designer?>?,
    val count_reviews: Int?,
    val reviews: List<Review?>?,
    val phone_number_1: String?,
    val phone_number_2: Any?,
    val phone_number_3: Any?,
    val email_1: String?,
    val email_2: Any?,
    val email_3: Any?,
    val social_media_1: String?,
    val social_media_2: String?,
    val social_media_3: String?,
    val social_media_4: Any?,
    val address: String?
) {
    data class Service(
        val id: Int?,
        val image: String?,
        val title: String?,
        val description: String?
    )

    data class Gallery(
        val id: Int?,
        val company: Int?,
        val image: String?,
        val about: String?
    )

    data class Package(
        val image: String?,
        val title: String?,
        val description: String?,
        val price: Int?,
        val tag: String?
    )

    data class Designer(
        val id: Int?,
        val photo: String?,
        val name: String?,
        val company_title: List<String?>?,
        val occupation: String?,
        val rating: Double?,
        val count_reviews: Int?
    )

    data class Review(
        val id: Int?,
        val rank: Int?,
        val company: Company?,
        val text: String?,
        val user_photo: String?,
        val username: String?,
        val time_since_published: String?
    ) {
        data class Company(
            val title: String?,
            val image_url: String?
        )
    }
}