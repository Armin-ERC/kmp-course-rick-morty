package org.aerc.rickmortyapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.aerc.rickmortyapp.ui.core.navigation.bottomnavigation.BottomBarItem
import org.aerc.rickmortyapp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper

@Composable
fun HomeScreen() {
    val items = listOf(
        BottomBarItem.Episodes(),
        BottomBarItem.Characters()
    )

    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomNavigation(items, navController) }) {
        Box{
            NavigationBottomWrapper(navController)
        }
    }
}

@Composable
fun BottomNavigation(items: List<BottomBarItem>, navController: NavHostController) {

    val navBarStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBarStackEntry?.destination

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                label = {
                    Text(item.title)
                },
                onClick = {
                    navController.navigate(route = item.route){
                        navController.graph.startDestinationRoute?.let{ route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selected = currentDestination?.route == item.route
            )
        }
    }
}
