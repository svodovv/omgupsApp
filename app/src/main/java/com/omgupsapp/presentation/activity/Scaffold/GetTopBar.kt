package com.omgupsapp.presentation.activity.Scaffold

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.omgupsapp.presentation.Screen

@Composable
fun GetTopBar(navController: NavController, route: String): @Composable (() -> Unit) {
    if (route == Screen.AuthScreen.route) {
        return {}
    } else {
        return { TopAppBarComposable(navController = navController) }
    }
}