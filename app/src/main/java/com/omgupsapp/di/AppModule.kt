package com.omgupsapp.di

import com.omgupsapp.common.Constants
import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.data.remote.AuthApi
import com.omgupsapp.data.repository.AuthRepositoryImpl
import com.omgupsapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyCookieJar(): MyCookieJar {
        return MyCookieJar()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cookieJar: MyCookieJar): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar) // Добавляем MyCookieJar в OkHttpClient
            .build()
    }


    @Provides
    @Singleton
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(provideOkHttpClient(provideMyCookieJar()))
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun authApi(): AuthApi {
        return retrofit().create(AuthApi::class.java)
    }


    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi, dataStoreManager: DataStoreManager): AuthRepository {
        return AuthRepositoryImpl(api,dataStoreManager)
    }


}
