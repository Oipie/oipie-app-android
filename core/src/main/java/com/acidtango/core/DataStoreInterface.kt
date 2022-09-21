package com.acidtango.core

interface DataStoreInterface {
    suspend fun writeToken(token: String)
    suspend fun readToken(): String
}
