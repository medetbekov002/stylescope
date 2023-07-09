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
import com.example.stylescope.data.remote.dtos.myreviews.MyReviewsDto
import com.example.stylescope.data.remote.dtos.recover.RecoverDto
import com.example.stylescope.data.remote.dtos.token.*
import retrofit2.http.*

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
    suspend fun getDetailCompany(@Path("id")id: Int): CompanyDetailDto

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
        @Body body:RegisterDto
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

    @GET("users/myreviews/")
    suspend fun getReviews():MyReviewsDto
}