package com.omgupsapp.presentation

sealed class Screen(val route: String) {
    object AuthScreen: Screen("auth_screen")

    object UserProfile: Screen("userProfile_screen")
}

sealed class NavigationGroup(val route: String){
    object AuthGroup: NavigationGroup("auth_screens")

    object HomeScreens: NavigationGroup("home_screens")
}