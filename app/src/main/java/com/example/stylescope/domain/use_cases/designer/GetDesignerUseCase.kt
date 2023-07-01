package com.example.stylescope.domain.use_cases.designer

import com.example.stylescope.domain.repository.designer.DesignerRepository

class GetDesignerUseCase(private val repository: DesignerRepository) {

    operator fun invoke() = repository.getDesigners()
}