package com.example.stylescope.domain.use_cases.company

import com.example.stylescope.domain.repository.company.CompanyRepository

class GetCompanyUseCase(private val repository: CompanyRepository) {

    operator fun invoke() = repository.getCompanies()
}