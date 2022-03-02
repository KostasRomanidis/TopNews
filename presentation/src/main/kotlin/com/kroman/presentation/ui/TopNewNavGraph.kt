package com.kroman.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kroman.presentation.ui.bookmarks.BookmarksScreen
import com.kroman.presentation.ui.home.HomeScreen
import com.kroman.presentation.ui.home.HomeViewModel


// Destinations used in the app
object TopNewsDestinations {
    const val HOME_ROUTE = "home"
    const val BOOKMARKS_ROUTE = "bookmarks"
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = TopNewsDestinations.HOME_ROUTE) {
        composable(TopNewsDestinations.HOME_ROUTE) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(homeViewModel = homeViewModel)
        }
        composable(TopNewsDestinations.BOOKMARKS_ROUTE) {
            BookmarksScreen()
        }
    }
}

// Models the navigation actions in the app
class TopNewsNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(TopNewsDestinations.HOME_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // To avoid multiple copies of the same destination when reselecting the same item
            launchSingleTop = true
            // Restore state
            restoreState = true
        }
    }
    var navigateToBookmarks: () -> Unit = {
        navController.navigate(TopNewsDestinations.BOOKMARKS_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: ImageVector, var destination: String) {
    object Home : BottomNavItem("Home", Icons.Outlined.Home, TopNewsDestinations.HOME_ROUTE)
    object Bookmarks :
        BottomNavItem("Bookmark", Icons.Outlined.Bookmark, TopNewsDestinations.BOOKMARKS_ROUTE)
}