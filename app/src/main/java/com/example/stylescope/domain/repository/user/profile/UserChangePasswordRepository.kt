package com.example.stylescope.domain.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.password.UserChangePasswordModel
import kotlinx.coroutines.flow.Flow

interface UserChangePasswordRepository {
//sdbvksjd
    fun changeUserPassword(model: UserChangePasswordModel): Flow<Either<String, List<String>>>
}