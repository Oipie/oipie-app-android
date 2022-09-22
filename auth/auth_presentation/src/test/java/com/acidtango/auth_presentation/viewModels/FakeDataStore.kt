package com.acidtango.auth_presentation.viewModels

import com.acidtango.core.DataStoreInterface

class FakeDataStore() : DataStoreInterface {
    override suspend fun writeToken(token: String) {}

    override suspend fun readToken(): String {
        return "fake-token"
    }
}