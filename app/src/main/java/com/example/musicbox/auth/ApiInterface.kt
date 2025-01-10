package com.example.musicbox.auth

import com.example.musicbox.models.LoginRequest
import com.example.musicbox.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("login")
    fun loginApi(@Body loginRequest: LoginRequest): Call<LoginResponse>

}