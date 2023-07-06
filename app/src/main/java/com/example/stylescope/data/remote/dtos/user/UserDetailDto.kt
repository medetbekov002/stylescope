package com.example.stylescope.data.remote.dtos.user

import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.user.UpdateUserImageModel
import com.example.stylescope.domain.model.user.UpdateUserProfileModel
import com.example.stylescope.domain.model.user.UserValidateModel
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
    val image: String? = null,
    val id: Int,
    val username: String,
    val email: String,
) : DataMapper<UserValidateModel> {
    override fun toDomain() = UserValidateModel(
        firstName = firstName,
        lastName = lastName,
        aboutMe = aboutMe,
        image = image,
        id = id,
        username = username,
        email = email,
    )
}

data class UpdateUserProfileDto(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("about_me")
    val aboutMe: String,
    val email: String
)

fun UpdateUserProfileModel.toData() = UpdateUserProfileDto(
    firstName = firstName,
    lastName = lastName,
    aboutMe = aboutMe,
    email = email
)
data class UpdateUserImageDto(
    val image: String
) : DataMapper<UpdateUserImageModel> {
    override fun toDomain() = UpdateUserImageModel(
        image = image
    )
}

fun UpdateUserImageModel.toData() = UpdateUserImageDto(
    image = image
)


