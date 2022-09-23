package com.acidtango.oipie.auth

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.acidtango.auth_presentation.ui.LoginScreen
import com.acidtango.auth_presentation.viewModels.LoginVM
import com.acidtango.core.DataStoreInterface
import com.acidtango.oipie.Base
import com.acidtango.oipie.navigation.Route
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@HiltAndroidTest
class LoginTest() {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Before
    fun setup() {
        hiltTestRule.inject()
        composeTestRule.setContent {
            navController = rememberNavController()
            Base(navController) {
                LoginScreen(
                    onRegistration = {
                        navController.navigate(Route.REGISTRATION)
                    },
                    onLogin = {
                        navController.navigate(Route.HOME)
                    },
                    viewModel = LoginVM(FakeDataStore())
                )
            }
        }
    }

    @Test
    fun test_navigates_to_home() {
        val text = "Login"
        composeTestRule.onNodeWithText(text).assertIsDisplayed()
        composeTestRule.onNodeWithText(text).performClick()
        assertThat(
            navController.currentDestination
                ?.route
                ?.startsWith(Route.HOME)
        ).isTrue()
    }

    @Test
    fun test_writeEmail() {
        val email = "maxverst@rb.com"
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Email").performTextInput(email)
        composeTestRule.onNodeWithText(email).assertIsDisplayed()
    }

    @Test
    fun test_writePassword() {
        val password = "password"
        composeTestRule.onNodeWithText("Password").assertIsDisplayed()
        composeTestRule.onNodeWithText("Password").performTextInput(password)
        composeTestRule.onNodeWithTag("show_password_btn").performClick()
        composeTestRule.onNodeWithText(password).assertIsDisplayed()
    }
}

class FakeDataStore() : DataStoreInterface {
    override suspend fun writeToken(token: String) {}

    override suspend fun readToken(): String {
        return ""
    }
}
