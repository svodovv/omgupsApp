package com.omgupsapp.domain.use_case.login

import android.util.Log
import com.omgupsapp.common.Resource
import com.omgupsapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(
        login: String, password: String
    ): Flow<Resource<Boolean>> = flow {
        try {

            emit(Resource.Loading())
            val userAuthenticated = repository.authentication(
                login = login,
                password = password
            )
            emit(Resource.Success(userAuthenticated))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "LoginUseCase error in http"))
            Log.e("csrfToken", e.localizedMessage ?: "Error login http in LoginUseCase")
        } catch (e: java.io.IOException) {
            emit(Resource.Error(e.localizedMessage ?: "LoginUseCase error in IO"))
            Log.e("csrfToken", e.localizedMessage ?: "Error login IO in LoginUseCase")
        }
    }

}