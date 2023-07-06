package com.example.stylescope.domain.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.user.UpdateUserImageModel
import kotlinx.coroutines.flow.Flow

interface UpdateUserImageRepository {
    fun updateUserImage(model: UpdateUserImageModel): Flow<Either<String, UpdateUserImageModel>>
}