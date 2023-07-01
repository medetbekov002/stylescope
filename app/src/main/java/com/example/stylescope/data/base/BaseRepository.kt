package com.example.stylescope.data.base

import com.example.stylescope.common.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> makeNetworkRequest(
    gatherIsSucceed: ((T) -> Unit)? = null,
    request: suspend() -> T
) =
    flow<Either<String, T>> {
        request().also {
            gatherIsSucceed?.invoke(it)
            emit(Either.Right(value = it))
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
        emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred !"))
    }
