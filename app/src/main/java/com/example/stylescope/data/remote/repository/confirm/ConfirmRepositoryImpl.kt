package com.example.stylescope.data.remote.repository.confirm

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.confirm.toConfirmDto
import com.example.stylescope.data.remote.dtos.confirm.toResendConfirmDto
import com.example.stylescope.data.remote.dtos.recover.toRecoverDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.confirm.ConfirmModel
import com.example.stylescope.domain.model.confirm.ResendConfirmModel
import com.example.stylescope.domain.model.recover.RecoverModel
import com.example.stylescope.domain.repository.confirm.ConfirmRepository
import kotlinx.coroutines.flow.Flow

class ConfirmRepositoryImpl(private val apiService: ApiService):ConfirmRepository {
    override fun confirm(code: ConfirmModel): Flow<Either<String, AnswerModel>> = makeNetworkRequest {
        apiService.confirm(code.toConfirmDto()).toDomain()
    }

    override fun resendConfirm(userName: ResendConfirmModel): Flow<Either<String, List<String>>> = makeNetworkRequest{
        apiService.resendConfirm(userName.toResendConfirmDto())
    }

    override fun resendRecover(email: RecoverModel): Flow<Either<String, List<String>>> = makeNetworkRequest{
        apiService.resendRecover(email.toRecoverDto())
    }

}