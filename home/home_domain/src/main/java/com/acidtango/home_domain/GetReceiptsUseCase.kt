package com.acidtango.home_domain

import kotlinx.coroutines.flow.Flow

class GetReceiptsUseCase(
    private val repository: ReceiptRepository
) {
    suspend operator fun invoke(): Flow<Resource<Receipts>> {
        return repository.getAllReceipts(0, 4)
    }
}

sealed class ErrorEntity {
    class ApiError(val code: Int, val message: String = "") : ErrorEntity()
    class UnknownError(val exception: Exception, val message: UiText) : ErrorEntity()
}
