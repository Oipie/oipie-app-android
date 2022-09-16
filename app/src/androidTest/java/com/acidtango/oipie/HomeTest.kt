package com.acidtango.oipie

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.acidtango.home_domain.GetReceiptsUseCase
import com.acidtango.home_presentation.HomeScreen
import com.acidtango.home_presentation.HomeViewModel
import com.acidtango.oipie.fakes.RecipesRepositoryFake
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@HiltAndroidTest
class HomeTest() {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createComposeRule()

    @Before
    fun setup() {
        hiltTestRule.inject()
        composeTestRule.setContent {
            HomeScreen(viewModel = HomeViewModel(GetReceiptsUseCase(RecipesRepositoryFake())))
        }
    }

    @Test
    fun test_titleIsDisplayed() {
        val text = "Slutty Pumpkin"
        composeTestRule.onNodeWithText(text.uppercase()).assertIsDisplayed()
    }
}
