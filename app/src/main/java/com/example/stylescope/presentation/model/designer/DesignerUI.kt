package com.example.stylescope.presentation.model.designer

import com.example.stylescope.domain.model.designer.DesignReviewModel
import com.example.stylescope.domain.model.designer.DesignerDetailModel
import com.example.stylescope.domain.model.designer.DesignerGalleryModel
import com.example.stylescope.domain.model.designer.DesignerModel


data class DesignerUI(
    val id: Int,
    val name: String,
    val photo: String,
    val companyTitle: List<String>,
    val occupation: String,
    val rating: String,
    val countReviews: String
)

fun DesignerModel.toUI() = DesignerUI(
    id = id,
    name = name,
    photo = photo,
    companyTitle = companyTitle,
    occupation = occupation,
    rating = rating,
    countReviews = countReviews
)

data class DesignerDetailUI(
    val name: String,
    val surname: String,
    val photo: String,
    val workEXP: String,
    val occupation: String,
    val description: String,
    val phoneNumber: String,
    val email: String,
    val instagram: String,
    val gallery: List<DesignerGalleryUI>,
    val rating: String,
    val countReviews: String,
    val reviews: List<DesignReviewUI>
)

fun DesignerDetailModel.toUI() = DesignerDetailUI(
    name = name,
    surname = surname,
    photo = photo,
    workEXP = workEXP,
    occupation = occupation,
    description = description,
    phoneNumber = phoneNumber,
    email = email,
    instagram = instagram,
    gallery = gallery.map { it.toUI() },
    rating = rating,
    countReviews = countReviews,
    reviews = reviews.map { it.toUI() }
)

data class DesignerGalleryUI(
    val about: String,
    val image: String
)

fun DesignerGalleryModel.toUI() = DesignerGalleryUI(
    about = about,
    image = image
)

data class DesignReviewUI(
    val id: Int,
    val rank: Int,
    val text: String,
    val user_photo: String,
    val designer: RVDesignerUI,
    val username: String,
    val time_since_published: String
)

fun DesignReviewModel.toUI() = DesignReviewUI(
    id = id,
    rank = rank,
    text = text,
    user_photo = user_photo,
    designer = designer.toUI(),
    username = username,
    time_since_published = time_since_published
)


data class RVDesignerUI(
    val name: String,
    val photo_url: String
)

fun DesignReviewModel.RVDesignerModel.toUI() = RVDesignerUI(
    name = name,
    photo_url = photo_url
)


