package com.example.stylescope.data.remote.repository.company

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.makeNetworkRequest
import com.example.stylescope.data.remote.service.ApiService
import com.example.stylescope.domain.model.company.CompanyDetailModel
import com.example.stylescope.domain.model.company.CompanyModel
import com.example.stylescope.domain.repository.company.CompanyRepository
import kotlinx.coroutines.flow.Flow

class CompanyRepositoryImpl(private val apiService: ApiService) : CompanyRepository {
    override fun getCompanies(): Flow<Either<String, List<CompanyModel>>> = makeNetworkRequest {
        apiService.getCompanies().map { it.toDomain() }
    }

    override fun getDetailCompany(id: Int): Flow<Either<String, CompanyDetailModel>> = makeNetworkRequest {
        apiService.getDetailCompany(id).toDomain()
    }
}