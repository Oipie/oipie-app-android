package com.acidtango.oipie.navigation

import com.acidtango.core_ui.R

object Route {
    const val LIST = "receipt_list"
    const val SEARCH = "search"
    const val FAVORITES = "favorites"
    const val MY_RECEIPTS = "my_receipts"
    const val PROFILE = "profile"

}

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object HOME : BottomNavItem(
        title = "Home",
        icon = R.drawable.ic_home,
        route = Route.LIST
    )

    object SEARCH : BottomNavItem(
        title = "Search",
        icon = R.drawable.ic_search,
        route = Route.SEARCH
    )

    object FAVORITES : BottomNavItem(
        title = "Favorites",
        icon = R.drawable.ic_favorites,
        route = Route.FAVORITES
    )

    object MY_RECEIPTS : BottomNavItem(
        title = "DONE",
        icon = R.drawable.ic_page_flip,
        route = Route.MY_RECEIPTS
    )

    object PROFILE : BottomNavItem(
        title = "Profile",
        icon = R.drawable.ic_profile,
        route = Route.PROFILE
    )
}