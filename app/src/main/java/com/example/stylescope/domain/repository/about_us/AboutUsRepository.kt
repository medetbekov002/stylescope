package com.example.stylescope.domain.repository.about_us

import com.example.stylescope.common.Either
import com.example.stylescope.presentation.model.about_us.AboutUI
import kotlinx.coroutines.flow.Flow

interface AboutUsRepository {

    fun getAboutUs(): Flow<Either<String, AboutUI>>
}