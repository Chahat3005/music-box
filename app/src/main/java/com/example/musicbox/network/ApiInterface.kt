package com.example.musicbox.network

import com.example.musicbox.models.AuthResponse
import com.example.musicbox.models.ChangePasswordResponse
import com.example.musicbox.models.ForgotPasswordRequest
import com.example.musicbox.models.LoginRequest
import com.example.musicbox.models.LoginResponse
import com.example.musicbox.models.ResetRequest
import com.example.musicbox.models.SignupRequest
import com.example.musicbox.models.VerifyRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("login")
    fun loginApi(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("signup")
    fun signupApi(@Body signupRequest: SignupRequest): Call<LoginResponse>

    @POST("logout")
    fun logoutApi(): Call<AuthResponse>

    @POST("send-otp")
    fun forgotApi(@Body forgotRequest: ForgotPasswordRequest): Call<AuthResponse>

    @POST("verify-otp")
    fun verifyApi(@Body verifyRequest: VerifyRequest): Call<AuthResponse>

    @POST("reset-password")
    fun resetApi(@Body resetRequest: ResetRequest):Call<AuthResponse>

    @POST("change-password")
    fun changePasswordApi(): Call<ChangePasswordResponse>
}