package com.acidtango.home_domain

import dagger.Provides

interface ReceiptRepository {
    suspend fun getAllReceipts(offset: Int, limit: Int): Resource<Receipts>
}