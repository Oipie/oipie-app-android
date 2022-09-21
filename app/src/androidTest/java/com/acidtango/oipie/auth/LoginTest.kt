package com.acidtango.oipie.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.acidtango.auth_presentation.ui.LoginScreen
import com.acidtango.auth_presentation.viewModels.LoginVM
import com.acidtango.core.DataStoreInterface
import com.acidtango.home_domain.GetReceiptsUseCase
import com.acidtango.home_presentation.HomeScreen
import com.acidtango.home_presentation.HomeViewModel
import com.acidtango.oipie.fakes.RecipesRepositoryFake
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
            val scaffoldState = rememberScaffoldState()
            navController = rememberNavController()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) { it ->
                NavHost(
                    navController = navController,
                    startDestination = Route.LOGIN,
                    modifier = Modifier.padding(it)
                ) {
                    composable(Route.LOGIN) {
                        LoginVM(FakeDataStore())
                    }
                    composable(Route.HOME) {
                        HomeScreen(viewModel = HomeViewModel(GetReceiptsUseCase(RecipesRepositoryFake())))
                    }
                }
            }
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
        Thread.sleep(5000)
    }
}

class FakeDataStore() : DataStoreInterface {
    override suspend fun writeToken(token: String) {}

    override suspend fun readToken(): String {
        return ""
    }
}
