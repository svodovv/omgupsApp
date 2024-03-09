package com.omgupsapp.presentation.ui.SettingsScreen

import androidx.lifecycle.ViewModel
import com.omgupsapp.domain.use_case.logout.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogoutViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
) : ViewModel() {

    fun logout() {
        logoutUseCase()
    }
}
