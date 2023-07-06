package com.example.stylescope.domain.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.user.UserValidateModel
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {

    fun getUserProfile(): Flow<Either<String, UserValidateModel>>
}