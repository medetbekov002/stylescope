package com.example.stylescope.domain.use_cases.user.profile

import com.example.stylescope.domain.model.user.UpdateUserProfileModel
import com.example.stylescope.domain.repository.user.profile.UpdateUserProfileRepository

class UpdateUserProfileUseCase(private val repository: UpdateUserProfileRepository) {

    operator fun invoke(model: UpdateUserProfileModel) = repository.updateUserProfile(model)
}