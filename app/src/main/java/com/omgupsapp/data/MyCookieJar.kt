package com.omgupsapp.data

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import javax.inject.Inject

class MyCookieJar @Inject constructor(
) : CookieJar {
    private val cookieStore = HashMap<String, MutableList<Cookie>>()



    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        val hostCookies = cookieStore[url.host] ?: ArrayList()
        hostCookies.addAll(cookies)
        cookieStore[url.host] = hostCookies
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return cookieStore[url.host] ?: ArrayList()
    }

}