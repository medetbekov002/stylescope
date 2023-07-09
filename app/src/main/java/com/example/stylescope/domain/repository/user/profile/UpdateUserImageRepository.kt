package com.example.stylescope.domain.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.user.UpdateUserImageModel
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface UpdateUserImageRepository {
    fun updateUserImage(image: MultipartBody.Part): Flow<Either<String, UpdateUserImageModel>>
}