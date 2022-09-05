package com.acidtango.home_data.repositories

val receiptsJson = """
    {
        "items": [
            {
                "id": "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                "name": "Pumpkin soup",
                "favourite": true,
                "favouriteAmount": 245,
                "preparationTime": 900000,
                "cover": "https://i.imgur.com/ISxVZHA.png"
            },
            {
                "id": "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                "name": "French toast",
                "favourite": false,
                "favouriteAmount": 124,
                "preparationTime": 600000,
                "cover": "https://i.imgur.com/GNw5TTl.png"
            }
        ],
        "meta": {
            "totalItems": 343
        }
    }
""".trimIndent()