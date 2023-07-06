package com.example.stylescope.domain.use_cases.user.profile

import com.example.stylescope.domain.model.user.UpdateUserImageModel
import com.example.stylescope.domain.repository.user.profile.UpdateUserImageRepository

class UpdateUserImageUseCase(private val repository: UpdateUserImageRepository) {

    operator fun invoke(model: UpdateUserImageModel) = repository.updateUserImage(model)
}