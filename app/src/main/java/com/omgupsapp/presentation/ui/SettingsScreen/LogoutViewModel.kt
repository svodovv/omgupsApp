package com.omgupsapp.presentation.ui.SettingsScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omgupsapp.common.Resource
import com.omgupsapp.domain.use_case.logout.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LogoutViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
) : ViewModel(){

    private val _stateLogout = mutableStateOf(LogoutState())
    val stateLogout: State<LogoutState> = _stateLogout

    fun logout() {
        logoutUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateLogout.value = LogoutState(isLogout = result.data ?: false)
                }

                is Resource.Error -> {
                    _stateLogout.value = LogoutState(error = result.message ?: "Logout is bad")
                }

                is Resource.Loading -> {
                    _stateLogout.value = LogoutState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
