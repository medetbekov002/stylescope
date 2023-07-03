package com.example.stylescope.data.remote.service

import com.example.stylescope.common.Either
import com.example.stylescope.data.base.BaseMainResponse
import com.example.stylescope.data.remote.dtos.answers.AnswerDto
import com.example.stylescope.data.remote.dtos.answers.ListAnswerDto
import com.example.stylescope.data.remote.dtos.changepassword.ChangePasswordAnswerDto
import com.example.stylescope.data.remote.dtos.changepassword.ChangePasswordDto
import com.example.stylescope.data.remote.dtos.company.CompanyDetailDto
import com.example.stylescope.data.remote.dtos.company.CompanyDto
import com.example.stylescope.data.remote.dtos.confirm.ConfirmDto
import com.example.stylescope.data.remote.dtos.confirm.ResendConfirmDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDetailDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDto
import com.example.stylescope.data.remote.dtos.login.LoginDto
import com.example.stylescope.data.remote.dtos.login.RegisterDto
import com.example.stylescope.data.remote.dtos.recover.RecoverDto
import com.example.stylescope.domain.model.answers.AnswerModel
import com.example.stylescope.domain.model.confirm.ResendConfirmModel
import com.example.stylescope.domain.model.recover.RecoverModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("companies")
    suspend fun getCompanies(): BaseMainResponse<CompanyDto>

    @GET("companies/{id}")
    suspend fun getDetailCompany(@Path("id")id: Int): CompanyDetailDto

    @GET("designers")
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
    ):AnswerDto

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

}