package com.omgupsapp.data.remote;

import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/omgupsapp/data/remote/AuthApi;", "", "authentication", "Lretrofit2/Response;", "", "csrfToken", "login", "password", "rememberMe", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHtmlAuthPage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthApi {
    
    @retrofit2.http.GET(value = "/user/sign-in/login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHtmlAuthPage(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> $completion);
    
    @retrofit2.http.FormUrlEncoded
    @retrofit2.http.POST(value = "/user/sign-in/login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object authentication(@retrofit2.http.Field(value = "_csrf")
    @org.jetbrains.annotations.NotNull
    java.lang.String csrfToken, @retrofit2.http.Field(value = "LoginForm[identity]")
    @org.jetbrains.annotations.NotNull
    java.lang.String login, @retrofit2.http.Field(value = "LoginForm[password]")
    @org.jetbrains.annotations.NotNull
    java.lang.String password, @retrofit2.http.Field(value = "LoginForm[rememberMe]")
    @org.jetbrains.annotations.NotNull
    java.lang.String rememberMe, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> $completion);
}