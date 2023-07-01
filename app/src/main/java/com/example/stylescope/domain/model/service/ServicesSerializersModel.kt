package com.example.stylescope.domain.model.service

data class ServicesSerializersModel(
    val id: Int,
    val title: String,
    val description: String,
    val company: List<Int>
)
