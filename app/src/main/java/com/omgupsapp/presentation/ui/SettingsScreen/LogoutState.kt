package com.omgupsapp.presentation.ui.SettingsScreen

data class LogoutState (
    val isLoading: Boolean = false,
    val isLogout: Boolean = false,
    val error: String = ""
)