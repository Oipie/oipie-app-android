package com.acidtango.home_data.repositories

val receiptsJson = """
    {
        "items": [
            {
                "id_": "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                "name": "Pumpkin soup",
                "favourite": true,
                "favourite_amount": 245,
                "preparation_time": 900000,
                "cover": "https://i.imgur.com/ISxVZHA.png"
            },
            {
                "id_": "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                "name": "French toast",
                "favourite": false,
                "favourite_amount": 124,
                "preparation_time": 600000,
                "cover": "https://i.imgur.com/GNw5TTl.png"
            }
        ],
        "meta": {
            "totalItems": 343
        }
    }
""".trimIndent()
