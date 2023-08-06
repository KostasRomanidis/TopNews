package com.kroman.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kroman.presentation.theme.Grey100
import com.kroman.presentation.theme.Grey400
import com.kroman.presentation.theme.Grey700
import com.kroman.presentation.theme.TopNewsTheme
import java.util.*

@Composable
fun TopNewsApp() {
    TopNewsTheme {
        val navController = rememberNavController()

        val tabs = remember {
            listOf(
                BottomNavItem.Home, BottomNavItem.Bookmarks
            )
        }

        Scaffold(topBar = {
            TopNewAppBar(navController = navController)
        }, bottomBar = {
            TopNewsBottomBar(navController = navController, tabs = tabs)
        }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavigationGraph(navController = navController)
            }
        }
    }
}

@Composable
fun TopNewAppBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomNavItem.Home.destination
    TopAppBar(
        title = { Text(currentRoute.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }) },
        backgroundColor = Grey700,
        contentColor = Grey100,
        elevation = 8.dp
    )
}

@Composable
fun TopNewsBottomBar(navController: NavController, tabs: List<BottomNavItem>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomNavItem.Home.destination
    BottomNavigation(
        backgroundColor = Grey700,
    ) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(tab.icon, null) },
                label = { Text(tab.title) },
                selected = currentRoute == tab.destination,
                selectedContentColor = Grey100,
                unselectedContentColor = Grey400,
                onClick = {
                    if (tab.destination != currentRoute) {
                        navController.navigate(tab.destination) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                alwaysShowLabel = false,
            )
        }
    }
}