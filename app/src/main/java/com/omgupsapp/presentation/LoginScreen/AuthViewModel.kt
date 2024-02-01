package com.omgupsapp.presentation.LoginScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.omgupsapp.common.Resource
import com.omgupsapp.domain.use_case.get_csrf_token.GetCsrfTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel

class AuthViewModel @Inject constructor(
    private val getCsrfTokenUseCase: GetCsrfTokenUseCase
) : ViewModel() {
    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    init {
        getToken()
    }

    private fun getToken() {
        getCsrfTokenUseCase().onEach {result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AuthState(csrfToken = result.data?.csrfToken ?: "")
                }

                is Resource.Error -> {
                    _state.value = AuthState(error = result.message?: "Error in LoginViewModel")
                }

                is Resource.Loading -> {
                    _state.value = AuthState(isLoading = true)
                }

            }
        }
    }


    fun onChangeLogin(login: String){
        _state.value = AuthState(login = login)
    }

    fun onChangePassword(password: String){
        _state.value = AuthState(password = password)
    }

}