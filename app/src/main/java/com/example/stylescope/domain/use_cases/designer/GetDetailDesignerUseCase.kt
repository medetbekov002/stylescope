package com.example.stylescope.domain.use_cases.designer

import com.example.stylescope.domain.repository.designer.DesignerRepository

class GetDetailDesignerUseCase(private val repository: DesignerRepository) {

    operator fun invoke(id: Int) = repository.getDetailDesigner(id)
}
