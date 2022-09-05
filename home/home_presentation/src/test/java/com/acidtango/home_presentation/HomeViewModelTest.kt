package com.acidtango.home_presentation

import com.acidtango.home_domain.GetReceiptsUseCase
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptDetail
import com.acidtango.home_domain.Receipts
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        homeViewModel =
            HomeViewModel(receiptsUseCase = GetReceiptsUseCase(RecipesRepositoryFake()))
    }

    @Test
    fun `First Recipes call not empty`() {
        runBlocking {
            assertThat(homeViewModel.receipts).isEqualTo(
                Receipts(
                    meta = Meta(totalItems = 343), items = listOf(
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
    }
}