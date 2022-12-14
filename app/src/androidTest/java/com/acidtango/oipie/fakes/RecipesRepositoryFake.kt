package com.acidtango.oipie.fakes

import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptDetail
import com.acidtango.home_domain.ReceiptRepository
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipesRepositoryFake
@Inject
constructor() : ReceiptRepository {
    override suspend fun getAllReceipts(offset: Int, limit: Int): Flow<Resource<Receipts>> {
        return flow {
            emit(
                Resource.Success(
                    data = Receipts(
                        meta = Meta(totalItems = 343),
                        items = listOf(
                            ReceiptDetail(
                                id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                                name = "Slutty Pumpkin",
                                cover = "https://i.imgur.com/ISxVZHA.png",
                                favourite = true,
                                favouriteAmount = 245,
                                preparationTime = 900000,
                            ),
                            ReceiptDetail(
                                id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                                name = "French toast",
                                cover = "https://i.imgur.com/GNw5TTl.png",
                                favourite = false,
                                favouriteAmount = 124,
                                preparationTime = 600000,
                            )
                        )
                    )
                )
            )
        }
    }
}
