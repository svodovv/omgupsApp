package com.omgupsapp.data.repository;

import android.util.Log;
import com.omgupsapp.data.DataStoreManager;
import com.omgupsapp.data.remote.AuthApi;
import com.omgupsapp.domain.repository.AuthRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/omgupsapp/data/repository/AuthRepositoryImpl;", "Lcom/omgupsapp/domain/repository/AuthRepository;", "api", "Lcom/omgupsapp/data/remote/AuthApi;", "dataStoreManager", "Lcom/omgupsapp/data/DataStoreManager;", "(Lcom/omgupsapp/data/remote/AuthApi;Lcom/omgupsapp/data/DataStoreManager;)V", "csrfToken", "", "authentication", "", "login", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tokenExists", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepositoryImpl implements com.omgupsapp.domain.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.data.remote.AuthApi api = null;
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.data.DataStoreManager dataStoreManager = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String csrfToken;
    
    @javax.inject.Inject
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.omgupsapp.data.remote.AuthApi api, @org.jetbrains.annotations.NotNull
    com.omgupsapp.data.DataStoreManager dataStoreManager) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object tokenExists(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object authentication(@org.jetbrains.annotations.NotNull
    java.lang.String login, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}