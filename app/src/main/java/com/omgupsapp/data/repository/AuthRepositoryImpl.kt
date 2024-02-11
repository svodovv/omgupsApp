package com.omgupsapp.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.omgupsapp.data.remote.AuthApi
import com.omgupsapp.domain.repository.AuthRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {
    private var csrfToken: String? = null
    override suspend fun tokenExists(): Boolean {
        val response = api.getHtmlAuthPage()
        return if (response.isSuccessful) {
            csrfToken = response.body()?.let {
                parseMetaDataInHtmlDoc(it, "csrf-token")
            }
            Log.i("TOKEN", csrfToken ?: "TOKEN IS NULL")
            csrfToken.isNullOrEmpty()
        } else {
            Log.e(TAG, "repository did not receive a token")
            false
        }
    }


    override suspend fun authentication(
        login: String,
        password: String,
    ): Boolean {
        return if (csrfToken.isNullOrEmpty()) {
            val codeHttp = api.authentication(
                csrfToken = csrfToken!!,
                login = login,
                password = password,
                rememberMe = "1"
            ).code()
            codeHttp == 302
        } else {
            false
        }
    }
}