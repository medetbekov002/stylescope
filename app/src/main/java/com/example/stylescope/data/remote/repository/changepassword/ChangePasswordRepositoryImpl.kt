package com.example.stylescope.data.remote.repository.changepassword

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.changepassword.toChangePasswordDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.changepassword.ChangePasswordAnswerModel
import com.example.stylescope.domain.model.changepassword.ChangePasswordModel
import com.example.stylescope.domain.repository.changepassword.ChangePasswordRepository
import kotlinx.coroutines.flow.Flow

class ChangePasswordRepositoryImpl(private val apiService: ApiService): ChangePasswordRepository {
    override fun changePassword(body: ChangePasswordModel): Flow<Either<String, ChangePasswordAnswerModel>> = makeNetworkRequest {
        apiService.changePassword(body.toChangePasswordDto()).toDomain()
    }


}