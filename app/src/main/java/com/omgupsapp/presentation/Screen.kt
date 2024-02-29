package com.omgupsapp.presentation

sealed class Screen(val route: String) {
    object AuthScreen: Screen("auth_screen")
    object LogOutScreen: Screen("logOut_screen")
    object UserProfileScreen: Screen("userProfile_screen")
    object HomeScreen: Screen("home_screen")
    object ScheduleScreen: Screen("ScheduleScreen")
}

sealed class NavigationGroup(val route: String){
    object AuthGroup: NavigationGroup("auth_screens")

    object HomeScreens: NavigationGroup("home_screens")
}