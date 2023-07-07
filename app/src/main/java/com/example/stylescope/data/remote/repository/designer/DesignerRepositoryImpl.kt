package com.example.stylescope.data.remote.repository.designer

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.designer.DesignerDetailModel
import com.example.stylescope.domain.model.designer.DesignerModel
import com.example.stylescope.domain.repository.designer.DesignerRepository
import kotlinx.coroutines.flow.Flow

class DesignerRepositoryImpl(private val apiService: ApiService) : DesignerRepository {
    override fun getDesigners(): Flow<Either<String, List<DesignerModel>>> = makeNetworkRequest {
        apiService.getDesigners().map { it.toDomain() }
    }

    override fun getDetailDesigner(id: Int): Flow<Either<String, DesignerDetailModel>> = makeNetworkRequest {
        apiService.getDetailDesigner(id).toDomain()
    }
}