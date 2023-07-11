package com.example.stylescope.domain.repository.designer

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.designer.DesignerDetailModel
import com.example.stylescope.domain.model.designer.DesignerModel
import kotlinx.coroutines.flow.Flow

interface DesignerRepository {

    fun getDesigners(): Flow<Either<String, List<DesignerModel>>>
    fun getDetailDesigner(id: Int): Flow<Either<String, DesignerDetailModel>>
}
