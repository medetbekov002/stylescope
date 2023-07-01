package com.example.stylescope.domain.model.user

data class UserDetailModel(
    val id: Int,
    val image: String,
    val firstName: String,
    val lastName: String,
    val aboutMe: String,
    val username: String
)

data class UserValidateModel(
    val firstName: String,
    val lastName: String,
    val aboutMe: String,
    val image: String? = null
)

data class UpdateUserImageModel(
    val image: String
)


