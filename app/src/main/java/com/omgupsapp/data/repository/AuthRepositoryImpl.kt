package com.omgupsapp.data.repository

import com.omgupsapp.data.remote.AuthApi
import com.omgupsapp.data.remote.dto.CsrfTokenDto
import com.omgupsapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
): AuthRepository {
    override suspend fun getСsrfToken(): CsrfTokenDto =
        api.getСsrfToken()

}