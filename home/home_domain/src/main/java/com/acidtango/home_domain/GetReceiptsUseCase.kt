package com.acidtango.home_domain

import android.util.Log

class GetReceiptsUseCase(
    private val repository: ReceiptRepository
) {
    suspend operator fun invoke(): Resource<Receipts> {

        val result = repository.getAllReceipts(0, 4)
        Log.d("JFKEJWE", result.toString())

        return result

    }
}
