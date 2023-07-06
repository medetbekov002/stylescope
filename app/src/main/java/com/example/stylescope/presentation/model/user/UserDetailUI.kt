package com.example.stylescope.presentation.model.user

import android.provider.ContactsContract.Data
import com.example.stylescope.data.mapper.DataMapper
import com.example.stylescope.domain.model.user.UpdateUserImageModel
import com.example.stylescope.domain.model.user.UpdateUserProfileModel
import com.example.stylescope.domain.model.user.UserDetailModel
import com.example.stylescope.domain.model.user.UserValidateModel

data class UserDetailUI(
    val id: Int,
    val image: String,
    val firstName: String,
    val lastName: String,
    val aboutMe: String,
    val username: String
)

fun UserDetailModel.toUI() = UserDetailUI(
    id = id,
    image = image,
    firstName = firstName,
    lastName = lastName,
    aboutMe = aboutMe,
    username = username
)
data class UserValidateUI(
    val firstName: String,
    val lastName: String,
    val aboutMe: String,
    val image: String? = null,
    val id: Int,
    val username: String,
    val email: String,
)

fun UserValidateModel.toUI() = UserValidateUI(
    firstName = firstName,
    lastName = lastName,
    aboutMe = aboutMe,
    image = image,
    id = id,
    username = username,
    email = email
)

data class UpdateUserProfileUI(
    val firstName: String,
    val lastName: String,
    val aboutMe: String,
    val email: String
) : DataMapper<UpdateUserProfileModel> {
    override fun toDomain() = UpdateUserProfileModel(
        firstName = firstName,
        lastName = lastName,
        aboutMe = aboutMe,
        email = email
    )
}

data class UpdateUserImageUI(
    val image: String
) : DataMapper<UpdateUserImageModel> {
    override fun toDomain() = UpdateUserImageModel(
        image = image
    )
}

fun UpdateUserImageModel.toUI() = UpdateUserImageUI(
    image = image
)


