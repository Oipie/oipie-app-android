package com.acidtango.home_data.models

import com.squareup.moshi.Json

data class ReceiptsNetwork(
    @field:Json(name = "items")
    val items: List<ReceiptDetailNetwork>,
    @field:Json(name = "meta")
    val meta: MetaNetwork
)
