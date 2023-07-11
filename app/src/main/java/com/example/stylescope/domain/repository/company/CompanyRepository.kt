package com.example.stylescope.domain.repository.company

import com.example.stylescope.common.Either
import com.example.stylescope.domain.model.company.CompanyDetailModel
import com.example.stylescope.domain.model.company.CompanyModel
import kotlinx.coroutines.flow.Flow

interface CompanyRepository {

    fun getCompanies(): Flow<Either<String, List<CompanyModel>>>
    fun getDetailCompany(id: Int): Flow<Either<String, CompanyDetailModel>>
}
