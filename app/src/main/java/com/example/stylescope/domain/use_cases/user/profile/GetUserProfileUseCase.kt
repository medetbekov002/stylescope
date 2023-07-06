package com.example.stylescope.domain.use_cases.user.profile

import com.example.stylescope.domain.repository.user.profile.UserProfileRepository

class GetUserProfileUseCase(private val repository: UserProfileRepository) {

    operator fun invoke() = repository.getUserProfile()
}