package com.acidtango.auth_presentation.viewModels

import com.acidtango.core_testing.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule

class RegistrationVMTest {
    private lateinit var registrationVW: RegistrationVM

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        registrationVW =
            RegistrationVM()
    }

    /*@Test
    fun `First Recipes call not empty`() {
        runBlocking {
            Truth.assertThat(homeViewModel.receipts).isEqualTo(
                Receipts(
                    meta = Meta(totalItems = 343),
                    items = listOf(
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
            )
        }
    }*/
}
