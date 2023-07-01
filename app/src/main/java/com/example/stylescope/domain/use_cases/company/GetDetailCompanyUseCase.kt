package com.example.stylescope.domain.use_cases.company

import com.example.stylescope.domain.repository.company.CompanyRepository

class GetDetailCompanyUseCase(private val repository: CompanyRepository) {

    operator fun invoke(id: Int) = repository.getDetailCompany(id)
}