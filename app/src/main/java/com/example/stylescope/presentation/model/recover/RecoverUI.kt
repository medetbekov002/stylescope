package com.example.stylescope.presentation.model.recover

import com.example.stylescope.domain.model.recover.RecoverModel

data class RecoverUI(
    val email:String
)

fun RecoverUI.toRecoverModel() = RecoverModel(email)