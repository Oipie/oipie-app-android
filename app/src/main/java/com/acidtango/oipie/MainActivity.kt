package com.acidtango.oipie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.acidtango.core_ui.theme.OipieTheme
import com.acidtango.favorites_presentation.FavoritesScreen
import com.acidtango.home_presentation.HomeScreen
import com.acidtango.oipie.navigation.BottomNavigationBar
import com.acidtango.oipie.navigation.Route
import com.acidtango.profile_presentation.ProfileScreen
import com.acidtango.receipts_presentation.ReceiptsScreen
import com.acidtango.search_presentation.SearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OipieTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = rememberScaffoldState(),
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.LIST
                    ) {
                        composable(Route.LIST) {
                            HomeScreen()
                        }
                        composable(Route.SEARCH) {
                            SearchScreen()
                        }
                        composable(Route.FAVORITES) {
                            FavoritesScreen()
                        }
                        composable(Route.MY_RECEIPTS) {
                            ReceiptsScreen()
                        }
                        composable(Route.PROFILE) {
                            ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OipieTheme {
        Greeting("Android")
    }
}