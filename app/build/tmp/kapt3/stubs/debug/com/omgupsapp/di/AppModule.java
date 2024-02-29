package com.omgupsapp.di;

import com.omgupsapp.common.Constants;
import com.omgupsapp.data.DataStoreManager;
import com.omgupsapp.data.remote.AuthApi;
import com.omgupsapp.data.repository.AuthRepositoryImpl;
import com.omgupsapp.domain.repository.AuthRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/omgupsapp/di/AppModule;", "", "()V", "authApi", "Lcom/omgupsapp/data/remote/AuthApi;", "provideAuthRepository", "Lcom/omgupsapp/domain/repository/AuthRepository;", "api", "dataStoreManager", "Lcom/omgupsapp/data/DataStoreManager;", "provideMyCookieJar", "Lcom/omgupsapp/di/MyCookieJar;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "cookieJar", "retrofit", "Lretrofit2/Retrofit;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.omgupsapp.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.di.MyCookieJar provideMyCookieJar() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull
    com.omgupsapp.di.MyCookieJar cookieJar) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final retrofit2.Retrofit retrofit() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.data.remote.AuthApi authApi() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.domain.repository.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull
    com.omgupsapp.data.remote.AuthApi api, @org.jetbrains.annotations.NotNull
    com.omgupsapp.data.DataStoreManager dataStoreManager) {
        return null;
    }
}