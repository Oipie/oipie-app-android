package com.acidtango.home_data.models

import com.squareup.moshi.Json

data class ReceiptDetailNetwork(
    @field:Json(name = "cover")
    val cover: String,
    @field:Json(name = "favourite")
    val favourite: Boolean,
    @field:Json(name = "favouriteAmount")
    val favouriteAmount: Int,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "preparationTime")
    val preparationTime: Int
)