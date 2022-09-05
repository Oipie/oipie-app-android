package com.acidtango.home_data.network

import com.acidtango.home_data.models.MetaNetwork
import com.acidtango.home_data.models.ReceiptDetailNetwork
import com.acidtango.home_data.models.ReceiptsNetwork
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptDetail
import com.acidtango.home_domain.Receipts
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ReceiptsMapperTest {

    @Test
    fun `Map response model to Domain`() {
        val responseModel = ReceiptsNetwork(
            meta = MetaNetwork(totalItems = 343), items = listOf(
                ReceiptDetailNetwork(
                    id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                    name = "Pumpkin soup",
                    cover = "https://i.imgur.com/ISxVZHA.png",
                    favourite = true,
                    favouriteAmount = 245,
                    preparationTime = 900000,
                ),
                ReceiptDetailNetwork(
                    id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                    name = "French toast",
                    cover = "https://i.imgur.com/GNw5TTl.png",
                    favourite = false,
                    favouriteAmount = 124,
                    preparationTime = 600000,
                )
            )
        )
        val expected = Receipts(
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


        assertThat(responseModel.toDomain()).isEqualTo(expected)


    }
}