package com.example.stylescope.domain.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.user.UpdateUserProfileModel
import kotlinx.coroutines.flow.Flow

interface UpdateUserProfileRepository {

    fun updateUserProfile(updateUserProfileModel: UpdateUserProfileModel): Flow<Either<String, List<String>>>
}