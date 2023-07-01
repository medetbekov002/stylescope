package com.example.stylescope.data.remote.dtos.user

import com.google.gson.annotations.SerializedName

data class UserDetailDto(
    val id: Int,
    val image: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("about_me")
    val aboutMe: String,
    val username: String
)

data class UserValidateDto(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("about_me")
    val aboutMe: String,
    val image: String? = null
)

data class UpdateUserImageDto(
    val image: String
)


