package com.acidtango.oipie.navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.acidtango.core_ui.theme.OipieTheme
import com.acidtango.core_ui.theme.Purple
import com.acidtango.core_ui.utils.ClearRippleTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.HOME,
        BottomNavItem.SEARCH,
        BottomNavItem.FAVORITES,
        BottomNavItem.MY_RECEIPTS,
        BottomNavItem.PROFILE
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = ButtonDefaults.outlinedBorder,
                shape = RoundedCornerShape(45.dp, 45.dp, 0.dp, 0.dp)
            )
            .padding(PaddingValues(horizontal = 25.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { item ->

            CompositionLocalProvider(LocalRippleTheme provides ClearRippleTheme) {
                Column(
                    modifier = Modifier
                        .alignByBaseline(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Surface(
                        modifier = Modifier,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Box(
                                modifier = Modifier
                                    .size(5.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(
                                        if (currentRoute == item.route) Purple else Color.Transparent
                                    )
                            )
                            Spacer(modifier = Modifier.height(3.dp))


                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = null,
                                modifier = Modifier.height(33.dp)
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            if (currentRoute == item.route) {
                                Text(
                                    item.title.toUpperCase(Locale.current),
                                    style = TextStyle(fontSize = 10.sp),
                                    fontWeight = FontWeight.Medium,
                                    color = if (currentRoute == item.route) Purple else Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))

                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    OipieTheme {
        BottomNavigationBar(rememberNavController())
    }
}