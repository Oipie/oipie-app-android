package com.acidtango.oipie

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.acidtango.auth_presentation.ui.LoginScreen
import com.acidtango.auth_presentation.ui.RegistrationScreen
import com.acidtango.core_ui.theme.OipieTheme
import com.acidtango.favorites_presentation.FavoritesScreen
import com.acidtango.home_presentation.HomeScreen
import com.acidtango.oipie.navigation.BottomNavigationBar
import com.acidtango.oipie.navigation.Route
import com.acidtango.profile_presentation.ProfileScreen
import com.acidtango.receipts_presentation.ReceiptsScreen
import com.acidtango.search_presentation.SearchScreen
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if (!task.isSuccessful) {

                    return@OnCompleteListener
                }
                val token = task.result

                val msg = token
                Log.d("TOAGGGG", msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }
        )
        setContent {
            OipieTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = listOf(
        Route.HOME,
        Route.PROFILE,
        Route.MY_RECEIPTS,
        Route.SEARCH,
        Route.FAVORITES
    ).contains(
        navBackStackEntry?.destination?.route.toString()
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = rememberScaffoldState(),
        bottomBar = {
            if (showBottomBar) BottomNavigationBar(navController = navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Route.LOGIN,
            modifier = Modifier.padding(padding)
        ) {
            composable(Route.LOGIN) {
                LoginScreen(
                    onRegistration = {
                        navController.navigate(Route.REGISTRATION)
                    },
                    onLogin = {
                        navController.navigate(Route.HOME) {
                            popUpTo(Route.LOGIN) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
            composable(Route.HOME) {
                HomeScreen()
            }
            composable(Route.REGISTRATION) {
                RegistrationScreen()
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OipieTheme {
        Greeting()
    }
}
