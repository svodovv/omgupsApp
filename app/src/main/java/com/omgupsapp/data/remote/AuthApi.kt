package com.omgupsapp.data.remote

import com.omgupsapp.data.remote.dto.CsrfTokenDto
import retrofit2.http.GET


interface AuthApi{

    @GET("/sign-in/login")
    suspend fun getСsrfToken(): CsrfTokenDto
}