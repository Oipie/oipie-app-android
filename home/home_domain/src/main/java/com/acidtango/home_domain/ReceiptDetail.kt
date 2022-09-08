package com.acidtango.home_domain

data class ReceiptDetail(
    val cover: String?,
    val favourite: Boolean,
    val favouriteAmount: Int,
    val id: String,
    val name: String,
    val preparationTime: Int
)