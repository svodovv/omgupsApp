package com.omgupsapp.presentation.activity.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.omgupsapp.presentation.BottomNavigationItem
import com.omgupsapp.presentation.Screen

@Composable
fun GetNavigationBar(
    route: String,
    itemsBottomBar: List<BottomNavigationItem>,
    selectedItemIndex: MutableState<Int>,
    navController: NavHostController
): @Composable (() -> Unit) {
    if (route == Screen.AuthScreen.route) {
        return {}
    } else
        return {
        NavigationBarComposable(
            itemsBottomBar = itemsBottomBar,
            selectedItemIndex = selectedItemIndex,
            navController = navController
        )
    }
}