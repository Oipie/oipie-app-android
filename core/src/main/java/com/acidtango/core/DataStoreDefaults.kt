package com.acidtango.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first

class DataStoreDefaults(
    private val dataStore: DataStore<Preferences>
) {

    private val accessToken = stringPreferencesKey("jwt")

    suspend fun writeToken(token: String) {
        dataStore.edit { jwt ->
            jwt[accessToken] = token
        }
    }

    suspend fun readToken(): String {
        return dataStore.data.first()[accessToken] ?: ""
    }
}
