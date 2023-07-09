package com.example.stylescope.data.remote.repository.user.profile

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.password.toData
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.password.UserChangePasswordModel
import com.example.stylescope.domain.repository.user.profile.UserChangePasswordRepository
import kotlinx.coroutines.flow.Flow

//офвиыажлофвсщц
class UserChangePasswordRepositoryImpl(private val api: ApiService) : UserChangePasswordRepository {
    override fun changeUserPassword(model: UserChangePasswordModel): Flow<Either<String, List<String>>> =
        makeNetworkRequest { api.changeUserPassword(model.toData()) }
}