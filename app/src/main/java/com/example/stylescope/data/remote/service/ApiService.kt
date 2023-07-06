package com.example.stylescope.data.remote.service

import com.example.stylescope.data.base.BaseMainResponse
import com.example.stylescope.data.remote.dtos.answers.AnswerDto
import com.example.stylescope.data.remote.dtos.changepassword.ChangePasswordAnswerDto
import com.example.stylescope.data.remote.dtos.changepassword.ChangePasswordDto
import com.example.stylescope.data.remote.dtos.company.CompanyDetailDto
import com.example.stylescope.data.remote.dtos.company.CompanyDto
import com.example.stylescope.data.remote.dtos.confirm.ConfirmAnswerDto
import com.example.stylescope.data.remote.dtos.confirm.ConfirmDto
import com.example.stylescope.data.remote.dtos.confirm.ResendConfirmDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDetailDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDto
import com.example.stylescope.data.remote.dtos.favorite.FavoriteItemDto
import com.example.stylescope.data.remote.dtos.login.LoginDto
import com.example.stylescope.data.remote.dtos.login.RegisterDto
import com.example.stylescope.data.remote.dtos.recover.RecoverDto
import com.example.stylescope.data.remote.dtos.token.*
import retrofit2.http.*
import com.example.stylescope.data.remote.dtos.user.UpdateUserImageDto
import com.example.stylescope.data.remote.dtos.user.UpdateUserProfileDto
import com.example.stylescope.data.remote.dtos.user.UserValidateDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("users/favorite/")
    suspend fun getFavorite():FavoriteItemDto

    @POST("token/")
    suspend fun getToken(
        @Body body:GetTokenDto
    ):GetTokenAnswerDto

    @POST("token/refresh/")
    suspend fun refreshToken(
        @Body body:RefreshTokenDto
    ):RefreshTokenAnswerDto

    @POST("token/verify/")
    suspend fun verifyToken(
        @Body body: VerifyTokenDto
    ):VerifyTokenAnswerDto


    @GET("companies/")
    suspend fun getCompanies(): BaseMainResponse<CompanyDto>

    @GET("companies/{id}")
    suspend fun getDetailCompany(@Path("id") id: Int): CompanyDetailDto

    @GET("designers/")
    suspend fun getDesigners(): BaseMainResponse<DesignerDto>

    @GET("designers/{id}")
    suspend fun getDetailDesigner(@Path("id") id: Int) : DesignerDetailDto

    @POST("users/login/")
    suspend fun logIn(
        @Body body:LoginDto
    ):AnswerDto

    @POST("users/password_reset/")
    suspend fun recover(
        @Body body: RecoverDto
    ):List<String>

    @POST("users/register/")
    suspend fun register(
        @Body body: RegisterDto
    ):List<String>

    @POST("users/confirm/")
    suspend fun confirm(
        @Body code:ConfirmDto
    ):ConfirmAnswerDto

    @POST("users/resend_confirm_code/")
    suspend fun resendConfirm(
        @Body userName: ResendConfirmDto
    ):List<String>

    @POST("users/resend_reset_code/")
    suspend fun resendRecover(
        @Body email: RecoverDto
    ):List<String>

    @POST("users/password_reset/confirm")
    suspend fun changePassword(
        @Body body:ChangePasswordDto
    ):ChangePasswordAnswerDto

    @GET("users/profile/")
    suspend fun getUserProfile(
        @Header("Authorization")
        token: String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjg4NjI3NTI3LCJpYXQiOjE2ODg2MjM5MjcsImp0aSI6IjBiMDU1NjU5ZmNlYzQwNjRiN2Q5N2MzNDEzMjE5NDJmIiwidXNlcl9pZCI6MTc3fQ.6hJF6x_dur1l0tFMp7gNXbMssXt2FS5ywE0t7slw-F4"
    ): UserValidateDto

    @PUT("users/profile/")
    suspend fun updateUserProfile(
        @Body model: UpdateUserProfileDto,
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjg4NjI3NTI3LCJpYXQiOjE2ODg2MjM5MjcsImp0aSI6IjBiMDU1NjU5ZmNlYzQwNjRiN2Q5N2MzNDEzMjE5NDJmIiwidXNlcl9pZCI6MTc3fQ.6hJF6x_dur1l0tFMp7gNXbMssXt2FS5ywE0t7slw-F4"
    ): List<String>

    @PATCH("users/update_image/")
    suspend fun updateUserImage(
        @Body model: UpdateUserImageDto,
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjg4NjI3NTI3LCJpYXQiOjE2ODg2MjM5MjcsImp0aSI6IjBiMDU1NjU5ZmNlYzQwNjRiN2Q5N2MzNDEzMjE5NDJmIiwidXNlcl9pZCI6MTc3fQ.6hJF6x_dur1l0tFMp7gNXbMssXt2FS5ywE0t7slw-F4"
    ) : UpdateUserImageDto
}