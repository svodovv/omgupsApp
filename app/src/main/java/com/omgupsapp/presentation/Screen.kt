package com.omgupsapp.presentation

sealed class Screen(val route: String) {
    object AuthScreen: Screen("auth_screen")
}