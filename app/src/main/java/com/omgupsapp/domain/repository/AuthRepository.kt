package com.omgupsapp.domain.repository

import com.omgupsapp.data.remote.dto.CsrfTokenDto

interface AuthRepository {
    suspend fun getСsrfToken(): CsrfTokenDto
}