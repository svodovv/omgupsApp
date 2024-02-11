package com.omgupsapp.presentation.LoginScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omgupsapp.common.Resource
import com.omgupsapp.domain.use_case.get_csrf_token.GetCsrfTokenUseCase
import com.omgupsapp.domain.use_case.login.AuthenticationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val getCsrfTokenUseCase: GetCsrfTokenUseCase,
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {
    private val _stateToken = mutableStateOf(AuthState())
    val stateToken: State<AuthState> = _stateToken

    private val _stateAuthentication = mutableStateOf(AuthenticationState())
    val stateAuthentication: State<AuthenticationState> = _stateAuthentication


    init {
        getToken()
    }

    private fun getToken() {
        getCsrfTokenUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateToken.value = AuthState(csrfToken = result.data ?: false)
                }

                is Resource.Error -> {
                    _stateToken.value = AuthState(error = result.message ?: "Token is invalid")
                }

                is Resource.Loading -> {
                    _stateToken.value = AuthState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun userAuthenticated() {
        authenticationUseCase(
            login =  stateAuthentication.value.login,
            password = stateAuthentication.value.password
        ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateAuthentication.value =
                        _stateAuthentication.value.copy(userAuthenticated = result.data)
                }

                is Resource.Error -> {
                    _stateAuthentication.value =
                        _stateAuthentication.value.copy(error = "Error in authenticated user")
                }

                is Resource.Loading -> {
                    _stateAuthentication.value = _stateAuthentication.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onChangeLogin(login: String) {
        _stateAuthentication.value = _stateAuthentication.value.copy(login = login)
    }

    fun onChangePassword(password: String) {
        _stateAuthentication.value = _stateAuthentication.value.copy(password = password)
    }

}