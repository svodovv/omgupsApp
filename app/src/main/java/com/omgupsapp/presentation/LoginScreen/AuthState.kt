package com.omgupsapp.presentation.LoginScreen

data class AuthState(
    val isLoading: Boolean = false,
    val csrfToken:Boolean = false,
    val error: String = ""
)