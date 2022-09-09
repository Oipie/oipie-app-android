package com.acidtango.home_domain

import kotlinx.coroutines.flow.Flow

interface ReceiptRepository {
    suspend fun getAllReceipts(offset: Int, limit: Int): Flow<Resource<Receipts>>
}