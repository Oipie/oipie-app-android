package com.acidtango.home_domain

class GetReceiptsUseCase() {
    operator fun invoke(): Receipts {
        return Receipts(
            items = listOf(
                ReceiptDetail(
                    id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                    name = "Pumpkin soup",
                    cover = "https://i.imgur.com/ISxVZHA.png",
                    favourite = true,
                    favouriteAmount = 254,
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
            ), meta = Meta(totalItems = 2)
        )
    }
}
