package com.acidtango.home_presentation

import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptDetail
import com.acidtango.home_domain.ReceiptRepository
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource

class RecipesRepositoryFake : ReceiptRepository {
    override suspend fun getAllReceipts(offset: Int, limit: Int): Resource<Receipts> {
        return Resource.Success(
            data = Receipts(
                meta = Meta(totalItems = 343), items = listOf(
                    ReceiptDetail(
                        id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                        name = "Pumpkin soup",
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
    }
}