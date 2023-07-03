package com.example.stylescope.domain.use_cases.recover

import com.example.stylescope.domain.model.recover.RecoverModel
import com.example.stylescope.domain.repository.recover.RecoverRepository

class RecoverUseCase(private val repository: RecoverRepository) {

    operator fun invoke(body:RecoverModel) = repository.recover(body)

}