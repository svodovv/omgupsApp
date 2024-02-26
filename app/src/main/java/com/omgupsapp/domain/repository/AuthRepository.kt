package com.omgupsapp.domain.repository

interface AuthRepository {
    suspend fun tokenExists(): Boolean
    suspend fun authentication(login: String, password: String): Boolean
}