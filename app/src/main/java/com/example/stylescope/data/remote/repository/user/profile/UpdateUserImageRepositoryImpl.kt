package com.example.stylescope.data.remote.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.user.toData
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.user.UpdateUserImageModel
import com.example.stylescope.domain.repository.user.profile.UpdateUserImageRepository
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

class UpdateUserImageRepositoryImpl(private val api: ApiService) : UpdateUserImageRepository {
    override fun updateUserImage(image: MultipartBody.Part): Flow<Either<String, UpdateUserImageModel>> =
        makeNetworkRequest { api.updateUserImage(image = image).toDomain() }
}