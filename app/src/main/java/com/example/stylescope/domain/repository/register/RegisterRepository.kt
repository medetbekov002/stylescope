package com.example.stylescope.domain.repository.register

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.login.RegisterModel
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {

    fun register(body:RegisterModel):Flow<Either<String,List<String>>>

}