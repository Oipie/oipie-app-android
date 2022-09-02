package com.acidtango.home_data.network

import com.acidtango.home_data.models.ReceiptsNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface ReceiptsApi {
    @GET("recepies")
    suspend fun getReceipts(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ReceiptsNetwork
}