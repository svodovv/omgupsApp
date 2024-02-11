package com.omgupsapp.di;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/omgupsapp/di/MyCookieJar;", "Lokhttp3/CookieJar;", "()V", "cookieStore", "Ljava/util/HashMap;", "", "", "Lokhttp3/Cookie;", "loadForRequest", "", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "app_debug"})
public final class MyCookieJar implements okhttp3.CookieJar {
    @org.jetbrains.annotations.NotNull
    private final java.util.HashMap<java.lang.String, java.util.List<okhttp3.Cookie>> cookieStore = null;
    
    @javax.inject.Inject
    public MyCookieJar() {
        super();
    }
    
    @java.lang.Override
    public void saveFromResponse(@org.jetbrains.annotations.NotNull
    okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.Cookie> cookies) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<okhttp3.Cookie> loadForRequest(@org.jetbrains.annotations.NotNull
    okhttp3.HttpUrl url) {
        return null;
    }
}