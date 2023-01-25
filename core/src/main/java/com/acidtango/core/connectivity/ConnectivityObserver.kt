package com.acidtango.core.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Flow<Status>
    fun checkInternet(): Flow<Boolean>

    enum class Status {
        Available, Unavailable, Losing, Lost, Available_without_internet
    }
}
