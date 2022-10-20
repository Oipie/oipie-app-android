package com.acidtango.home_data.models

import com.squareup.moshi.Json

data class MetaNetwork(
    @field:Json(name = "totalItems")
    val totalItems: Int
)
