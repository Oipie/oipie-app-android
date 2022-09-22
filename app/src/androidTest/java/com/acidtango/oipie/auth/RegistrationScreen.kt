package com.acidtango.oipie.auth

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.acidtango.auth_presentation.ui.RegistrationScreen
import com.acidtango.auth_presentation.viewModels.RegistrationVM
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@HiltAndroidTest
class RegistrationScreen() {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createComposeRule()

    @Before
    fun setup() {
        hiltTestRule.inject()
        composeTestRule.setContent {
            RegistrationScreen(viewModel = RegistrationVM())
        }
    }

    @Test
    fun test_writeNickName() {
        val nickName = "xXLocoXx"
        composeTestRule.onNodeWithText("Nickname").assertIsDisplayed()
        composeTestRule.onNodeWithText("Nickname").performTextInput(nickName)
        composeTestRule.onNodeWithText(nickName).assertIsDisplayed()
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
