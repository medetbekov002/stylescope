package com.example.stylescope.domain.use_cases.user.profile

import com.example.stylescope.domain.model.password.UserChangePasswordModel
import com.example.stylescope.domain.repository.user.profile.UserChangePasswordRepository

//asdnasd
class UserChangePasswordUseCase(private val repository: UserChangePasswordRepository) {
    operator fun invoke(model: UserChangePasswordModel) = repository.changeUserPassword(model)
}