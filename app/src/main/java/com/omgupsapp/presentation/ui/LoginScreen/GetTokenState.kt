package com.omgupsapp.presentation.ui.LoginScreen

data class GetTokenState(
    val isLoading: Boolean = false,
    val csrfToken: Boolean = false,
    val error: String = ""
)