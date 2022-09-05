package com.acidtango.home_domain

class GetReceiptsUseCase(
    private val repository: ReceiptRepository
) {
    suspend operator fun invoke(): Resource<Receipts> {

        return repository.getAllReceipts(0, 4)

    }
}
