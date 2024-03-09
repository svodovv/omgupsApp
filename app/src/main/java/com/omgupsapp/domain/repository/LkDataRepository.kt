package com.omgupsapp.domain.repository

import retrofit2.Response

interface LkDataRepository {
    suspend fun getAcademicPlan(): Response<String>
}