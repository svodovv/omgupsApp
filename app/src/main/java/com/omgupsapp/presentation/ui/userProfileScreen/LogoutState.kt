package com.omgupsapp.presentation.ui.userProfileScreen

data class LogoutState (
    val isLoading: Boolean = false,
    val isLogout: Boolean = false,
    val error: String = ""
)