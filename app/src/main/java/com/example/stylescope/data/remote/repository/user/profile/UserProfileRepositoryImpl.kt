package com.example.stylescope.data.remote.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.local.Pref
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.user.UserValidateModel
import com.example.stylescope.domain.repository.user.profile.UserProfileRepository
import kotlinx.coroutines.flow.Flow

class UserProfileRepositoryImpl(private val api: ApiService, private val pref: Pref) : UserProfileRepository {
    override fun getUserProfile(): Flow<Either<String, UserValidateModel>> = makeNetworkRequest {
        api.getUserProfile().toDomain()
    }
}