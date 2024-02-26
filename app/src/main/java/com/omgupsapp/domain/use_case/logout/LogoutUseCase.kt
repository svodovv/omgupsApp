package com.omgupsapp.domain.use_case.logout

import android.util.Log
import com.omgupsapp.common.Resource
import com.omgupsapp.domain.repository.LogoutRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    val repository: LogoutRepository
) {
    operator fun invoke(): Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading())
            val logout = repository.logout()
            emit(Resource.Success(logout))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "LogoutUseCase error in http"))
            Log.e("csrfToken", e.localizedMessage ?: "Error in LogoutUseCase")
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "LogoutUseCase error in IO"))
            Log.e("csrfToken", e.localizedMessage ?: "Error in LogoutUseCase")
        }
    }
}