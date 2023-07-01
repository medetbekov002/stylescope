package com.example.stylescope.domain.use_cases.about_us

import com.example.stylescope.domain.repository.about_us.AboutUsRepository

class GetAboutUsUseCase(private val repository: AboutUsRepository) {

    operator fun invoke() = repository.getAboutUs()
}