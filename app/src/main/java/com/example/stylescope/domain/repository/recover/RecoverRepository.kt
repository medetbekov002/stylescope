package com.example.stylescope.domain.repository.recover

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.answers.ListAnswerModel
import com.example.stylescope.domain.model.recover.RecoverModel
import kotlinx.coroutines.flow.Flow

interface RecoverRepository {

    fun recover(body:RecoverModel):Flow<Either<String,List<String>>>

}