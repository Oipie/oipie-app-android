package com.acidtango.home_data.network

import com.acidtango.home_data.models.MetaNetwork
import com.acidtango.home_data.models.ReceiptDetailNetwork
import com.acidtango.home_data.models.ReceiptsNetwork
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptDetail
import com.acidtango.home_domain.Receipts

fun ReceiptDetailNetwork.toDomain() = ReceiptDetail(
    id = this.id,
    cover = this.cover,
    name = this.name,
    favourite = this.favourite,
    favouriteAmount = this.favouriteAmount,
    preparationTime = this.preparationTime.toLong()
)

fun MetaNetwork.toDomain() = Meta(totalItems = this.totalItems)

fun ReceiptsNetwork.toDomain() = Receipts(
    items = this.items.map { it.toDomain() },
    meta = this.meta.toDomain()
)