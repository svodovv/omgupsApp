package com.omgupsapp.data.repository

import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.data.remote.Retrofit.LogoutApi
import com.omgupsapp.domain.repository.LogoutRepository
import javax.inject.Inject

class LogoutRepositoryImpl @Inject constructor(
    val dataStoreManager: DataStoreManager, val api: LogoutApi
) : LogoutRepository {
    override suspend fun logout() {
        dataStoreManager.saveLoggedIn(false).also {
            api.logout()
        }

    }
}