package com.acidtango.home_data.repositories

import com.acidtango.home_data.R
import com.acidtango.home_data.network.ReceiptsApi
import com.acidtango.home_data.network.toDomain
import com.acidtango.home_domain.ErrorEntity
import com.acidtango.home_domain.ReceiptRepository
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource
import com.acidtango.home_domain.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ReceiptRepositoryApi constructor(
    private val api: ReceiptsApi
) : ReceiptRepository {
    override suspend fun getAllReceipts(offset: Int, limit: Int): Flow<Resource<Receipts>> {
        return flow {
            try {
                emit(Resource.Success(api.getReceipts(offset, limit).toDomain()))
            } catch (e: HttpException) {
                emit(Resource.Error(ErrorEntity.ApiError(code = e.code(), message = e.message())))
            } catch (e: Exception) {
                emit(
                    Resource.Error(
                        ErrorEntity.UnknownError(
                            exception = e,
                            message = UiText.StringResource(R.string.unknown_error)
                        )
                    )
                )
            }
        }
    }
}
