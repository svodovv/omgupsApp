package com.omgupsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.presentation.NavigationGroup
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.LoginScreen.components.AuthScreen
import com.omgupsapp.presentation.ui.userProfileScreen.composable.LogoutScreen


@Composable
fun NavControllerComposable(navController: NavHostController, dataStoreManager: DataStoreManager) {

    val isLoggedIn = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        dataStoreManager.getLoggedIn().collect {
            isLoggedIn.value = it
        }
    }

    val startDestination = if (!isLoggedIn.value) NavigationGroup.HomeScreens.route
    else NavigationGroup.AuthGroup.route

    NavHost(
        navController = navController, startDestination = NavigationGroup.AuthGroup.route
    ) {

        navigation(
            startDestination = Screen.AuthScreen.route, route = NavigationGroup.AuthGroup.route
        ) {
            composable(route = Screen.AuthScreen.route) {
                AuthScreen(navController = navController)
            }

            /*
                Если появятся такие страницы как забыли пароль или регистрация, все должно быть тут
             */
        }
        navigation(
            startDestination = Screen.UserProfile.route, route = NavigationGroup.HomeScreens.route
        ) {
            composable(route = Screen.UserProfile.route) {
                LogoutScreen(navController = navController)
            }
        }
    }
}