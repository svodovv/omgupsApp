package com.omgupsapp.data.remote.Retrofit

import retrofit2.Response
import retrofit2.http.GET

interface LogoutApi {
    @GET("/user/sign-in/logout")
    suspend fun logout(): Response<String>
}