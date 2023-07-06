package com.example.stylescope.data.remote.service

import com.example.stylescope.data.base.BaseMainResponse
import com.example.stylescope.data.remote.dtos.company.CompanyDetailDto
import com.example.stylescope.data.remote.dtos.company.CompanyDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDetailDto
import com.example.stylescope.data.remote.dtos.designer.DesignerDto
import com.example.stylescope.data.remote.dtos.login.RegisterDto
import com.example.stylescope.data.remote.dtos.user.UpdateUserImageDto
import com.example.stylescope.data.remote.dtos.user.UpdateUserProfileDto
import com.example.stylescope.data.remote.dtos.user.UserValidateDto
import com.example.stylescope.domain.model.login.RegisterModel
import com.google.gson.Gson
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("companies")
    suspend fun getCompanies(): BaseMainResponse<CompanyDto>

    @GET("companies/{id}")
    suspend fun getDetailCompany(@Path("id") id: Int): CompanyDetailDto

    @GET("designers")
    suspend fun getDesigners(): BaseMainResponse<DesignerDto>

    @GET("designers/{id}")
    suspend fun getDetailDesigner(@Path("id") id: Int): DesignerDetailDto

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