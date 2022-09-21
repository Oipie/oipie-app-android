package com.acidtango.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first

interface DataStoreInterface {
    suspend fun writeToken(token: String)
    suspend fun readToken(): String
}
