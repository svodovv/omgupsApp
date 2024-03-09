package com.omgupsapp.data.repository

import com.omgupsapp.data.remote.Retrofit.LkDataApi
import com.omgupsapp.domain.repository.LkDataRepository
import retrofit2.Response

class LkDataRepositoryImpl  constructor(
    private val lkDataApi: LkDataApi
): LkDataRepository{
    override suspend fun getAcademicPlan(): Response<String> {
        return TODO("asdasd")
    }
}