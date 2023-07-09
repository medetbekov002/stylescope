package com.example.stylescope.domain.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.password.ChangePasswordModel
import kotlinx.coroutines.flow.Flow

interface UserChangePasswordRepository {

    fun changeUserPassword(model: ChangePasswordModel): Flow<Either<String, List<String>>>
}