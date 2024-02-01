package com.omgupsapp.presentation.LoginScreen

data class AuthState(
    val isLoading: Boolean = false,
    val csrfToken: String = "",
    val login: String = "",
    val password: String = "",
    val error: String = ""
)