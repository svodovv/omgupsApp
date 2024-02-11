package com.omgupsapp.presentation.ui.LoginScreen

data class AuthState(
    val isLoading: Boolean = false,
    val csrfToken: Boolean = false,
    val error: String = ""
)