package com.omgupsapp.di

import android.app.Application
import com.omgupsapp.data.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreManager(app: Application): DataStoreManager {
        return DataStoreManager(app)
    }

}