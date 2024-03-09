package com.omgupsapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface LkDataApi {
    @GET("student/academicplan?_referrer=%2Fstudent%2Findex")
    suspend fun academicPlan(): Response<String>
}