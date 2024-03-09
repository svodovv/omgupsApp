package com.omgupsapp.presentation.activity.Scaffold

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.omgupsapp.presentation.BottomNavigationItem
import com.omgupsapp.presentation.Screen

@Composable
fun GetTopBar(
    navController: NavController,
    route: String,
    selectedTitle: String
) {
    if (route == Screen.AuthScreen.route) {
        /* Пустой @Composable */
    } else {
        TopAppBarComposable(
            navController = navController,
            selectedTitle = selectedTitle
            )
    }
}