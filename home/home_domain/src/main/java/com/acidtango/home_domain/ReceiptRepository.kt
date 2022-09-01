package com.acidtango.home_domain

interface ReceiptRepository {
    fun getAllReceipts(): Receipts
}