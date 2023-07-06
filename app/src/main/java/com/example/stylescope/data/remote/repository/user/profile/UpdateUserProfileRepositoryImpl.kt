package com.example.stylescope.data.remote.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.user.toData
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.user.UpdateUserProfileModel
import com.example.stylescope.domain.repository.user.profile.UpdateUserProfileRepository
import kotlinx.coroutines.flow.Flow

class UpdateUserProfileRepositoryImpl(private val api: ApiService) : UpdateUserProfileRepository {
    override fun updateUserProfile(updateUserProfileModel: UpdateUserProfileModel):
            Flow<Either<String, List<String>>> = makeNetworkRequest {
                api.updateUserProfile(model = updateUserProfileModel.toData()).map { it }
    }
}