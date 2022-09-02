package com.acidtango.home_data.repositories

import com.acidtango.home_data.network.ReceiptsApi
import com.acidtango.home_data.network.toDomain
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptRepository
import com.acidtango.home_domain.Receipts

class ReceiptRepositoryApi constructor(
    private val api: ReceiptsApi
) : ReceiptRepository {
    override suspend fun getAllReceipts(offset: Int, limit: Int): Receipts {
        return try {
            api.getReceipts(offset, limit).toDomain()
        } catch (e: Exception) {
            return Receipts(listOf(), Meta(0))
        }
    }
}