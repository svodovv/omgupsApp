package com.omgupsapp.presentation.ui.LoginScreen

import com.omgupsapp.common.Resource

data class AuthenticationState (
    val userAuthenticated: Boolean? = null,
    val error: String = "",
    val isLoading: Boolean = false,
    val login: String = "",
    val password: String = "",
)