package com.acidtango.home_data.models

import com.squareup.moshi.Json

data class ReceiptDetailNetwork(
    @field:Json(name = "cover")
    val cover: String?,
    @field:Json(name = "favourite")
    val favourite: Boolean,
    @field:Json(name = "favourite_amount")
    val favouriteAmount: Int,
    @field:Json(name = "id_")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "preparation_time")
    val preparationTime: Int
)
