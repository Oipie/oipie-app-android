package com.acidtango.core.dataStore

interface DataStoreInterface {
    suspend fun writeToken(token: String)
    suspend fun readToken(): String
}
