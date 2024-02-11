package com.omgupsapp.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.data.remote.AuthApi
import com.omgupsapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val dataStoreManager: DataStoreManager
) : AuthRepository {

    private var csrfToken: String? = null
    override suspend fun tokenExists(): Boolean {
        val response = api.getHtmlAuthPage()
        return if (response.isSuccessful) {
            csrfToken = response.body()?.let {
                parseMetaDataInHtmlDoc(it, "csrf-token")
            }
            Log.i("TOKEN", csrfToken ?: "TOKEN IS NULL")
            csrfToken != null
        } else {
            Log.e(TAG, "repository did not receive a token")
            false
        }
    }


    override suspend fun authentication(
        login: String,
        password: String,
    ): Boolean {
        val response = api.authentication(
            csrfToken = csrfToken!!,
            login = login,
            password = password,
            rememberMe = "1"
        )
        if (response.isSuccessful){
            val title = response.body()?.let {
                parseTitleInHtmlDoc(it)
            }
            if (title != null && title.contains("кабинет")) {
                dataStoreManager.saveLoggedIn(true)
                return true
            }
        }
        return false
    }
}