package com.example.stylescope.presentation.model.user

data class UserDetailUI(
    val id: Int,
    val image: String,
    val firstName: String,
    val lastName: String,
    val aboutMe: String,
    val username: String
)

data class UserValidateUI(
    val firstName: String,
    val lastName: String,
    val aboutMe: String,
    val image: String? = null
)

data class UpdateUserImageUI(
    val image: String
)


