package com.example.stylescope.data.remote.repository.recover

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.dtos.recover.toRecoverDto
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.answers.ListAnswerModel
import com.example.stylescope.domain.model.recover.RecoverModel
import com.example.stylescope.domain.repository.recover.RecoverRepository
import kotlinx.coroutines.flow.Flow

class RecoverRepositoryImpl(private val apiService: ApiService):RecoverRepository {

    override fun recover(body: RecoverModel): Flow<Either<String,List<String>>> = makeNetworkRequest{
        apiService.recover(body.toRecoverDto())
    }
}