package com.omgupsapp.data.repository

import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.data.remote.LogoutApi
import com.omgupsapp.domain.repository.LogoutRepository
import javax.inject.Inject

class LogoutRepositoryImpl @Inject constructor(
    val dataStoreManager: DataStoreManager,
    val api: LogoutApi
): LogoutRepository {
    override suspend fun logout(): Boolean {
        val response = api.logout()
        if (response.isSuccessful && response.code() == 200){
            dataStoreManager.saveLoggedIn(false)
            return true
        }
        return false
    }
}