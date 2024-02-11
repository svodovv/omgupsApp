package com.omgupsapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("data_store")

class DataStoreManager @Inject constructor(val context: Context) {

    suspend fun saveLoggedIn(isLoggedIn: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[isLoggedInKey] = isLoggedIn
        }
    }

    fun getLoggedIn(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[isLoggedInKey] ?: false
        }
    }

    companion object{
        val isLoggedInKey = booleanPreferencesKey("isLoggedInKey")
    }
}