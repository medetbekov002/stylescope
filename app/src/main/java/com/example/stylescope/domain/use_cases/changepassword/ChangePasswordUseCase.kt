package com.example.stylescope.domain.use_cases.changepassword

import com.example.stylescope.domain.model.changepassword.ChangePasswordModel
import com.example.stylescope.domain.repository.changepassword.ChangePasswordRepository

class ChangePasswordUseCase(private val repository: ChangePasswordRepository) {

    operator fun invoke(body:ChangePasswordModel) = repository.changePassword(body)

}