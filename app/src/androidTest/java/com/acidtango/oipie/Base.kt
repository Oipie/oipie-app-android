package com.acidtango.oipie

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.acidtango.auth_presentation.viewModels.LoginVM
import com.acidtango.home_domain.GetReceiptsUseCase
import com.acidtango.home_presentation.HomeScreen
import com.acidtango.home_presentation.HomeViewModel
import com.acidtango.oipie.auth.FakeDataStore
import com.acidtango.oipie.fakes.RecipesRepositoryFake
import com.acidtango.oipie.navigation.Route

@Composable
fun Base(navController: NavHostController, content: @Composable() () -> Unit) {
    val scaffoldState = rememberScaffoldState()
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

    content()
}
