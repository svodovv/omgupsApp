package com.omgupsapp.domain.use_case.logout

import com.omgupsapp.domain.repository.LogoutRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    val repository: LogoutRepository
) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    operator fun invoke() = coroutineScope.launch {
        repository.logout()
    }
}