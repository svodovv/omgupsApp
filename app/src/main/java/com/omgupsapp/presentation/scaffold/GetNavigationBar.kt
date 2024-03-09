package com.omgupsapp.presentation.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.omgupsapp.presentation.BottomNavigationItem
import com.omgupsapp.presentation.Screen

@Composable
fun GetNavigationBar(
    route: String,
    itemsBottomBar: List<BottomNavigationItem>,
    navController: NavHostController,
    selectedTitle: MutableState<String>
) {
    if (route == Screen.AuthScreen.route) {
        //Ничего)
    } else {
        NavigationBarComposable(
            itemsBottomBar = itemsBottomBar,
            navController = navController,
            route = route,
            selectedTitle = selectedTitle
        )
    }
}