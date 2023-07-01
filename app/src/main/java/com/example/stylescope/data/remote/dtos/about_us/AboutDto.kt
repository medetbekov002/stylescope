package com.example.stylescope.data.remote.dtos.about_us

import com.google.gson.annotations.SerializedName

data class AboutDto(
    val description: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    val instagram: String,
    val mail: String
)
