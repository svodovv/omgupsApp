package com.omgupsapp.data.repository

import com.omgupsapp.data.remote.LkDataApi
import com.omgupsapp.domain.repository.LkDataRepository
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import retrofit2.Response
import javax.inject.Inject

class LkDataRepositoryImpl  constructor(
    private val lkDataApi: LkDataApi
): LkDataRepository{
    override suspend fun getAcademicPlan(): Response<String> {
        return TODO("asdasd")
    }
}