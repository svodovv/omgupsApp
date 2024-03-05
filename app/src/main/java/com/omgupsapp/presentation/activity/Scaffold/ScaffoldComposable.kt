package com.omgupsapp.presentation.activity.Scaffold

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.omgupsapp.presentation.BottomNavigationItem

@Composable
fun ScaffoldComposable(
    navController: NavHostController,
    itemsBottomBar: List<BottomNavigationItem>,
    selectedItemIndex: MutableState<Int>,
    content: @Composable (PaddingValues) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Crossfade(targetState = navBackStackEntry?.destination?.route, label = "") { route ->

        Scaffold(
            topBar = {
                GetTopBar(navController = navController, route = route.toString())
            },
            bottomBar = {
                GetNavigationBar(
                    route = route.toString(),
                    itemsBottomBar = itemsBottomBar,
                    selectedItemIndex = selectedItemIndex,
                    navController = navController
                )
            }) { paddingValues ->
            content(paddingValues)
        }
    }
}