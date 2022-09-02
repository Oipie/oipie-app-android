package com.acidtango.home_data.repositories

import com.acidtango.home_data.network.ReceiptsApi
import com.acidtango.home_data.network.toDomain
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptRepository
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource

class ReceiptRepositoryApi constructor(
    private val api: ReceiptsApi
) : ReceiptRepository {
    override suspend fun getAllReceipts(offset: Int, limit: Int): Resource<Receipts> {
        return try {
            Resource.Success(api.getReceipts(offset, limit).toDomain())
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}