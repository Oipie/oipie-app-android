package com.acidtango.home_domain

data class Receipts(
    val items: List<ReceiptDetail>,
    val meta: Meta
)
