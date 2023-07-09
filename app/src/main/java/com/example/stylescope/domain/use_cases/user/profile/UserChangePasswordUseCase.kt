package com.example.stylescope.domain.use_cases.user.profile

import com.example.stylescope.domain.model.password.ChangePasswordModel
import com.example.stylescope.domain.repository.user.profile.UserChangePasswordRepository

class UserChangePasswordUseCase(private val repository: UserChangePasswordRepository) {
    operator fun invoke(model: ChangePasswordModel) = repository.changeUserPassword(model)
}