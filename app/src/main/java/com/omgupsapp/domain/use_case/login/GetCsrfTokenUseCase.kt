package com.omgupsapp.domain.use_case.login

import android.util.Log
import com.omgupsapp.common.Resource
import com.omgupsapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCsrfTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(): Flow<Resource<Boolean>> = flow {
        try {

            emit(Resource.Loading())
            val tokenExists = repository.tokenExists()
            emit(Resource.Success(tokenExists))

        } catch (e: HttpException) {
            emit(Resource.Error("Ошибка подключения к интернету, возможно, вызвана активным VPN-сервисом."))
            Log.e("csrfToken", e.localizedMessage ?: "Error csrfToken http in GetCsrfTokenUSeCase")
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "GetCsrfTokenUseCase error in IO"))
            Log.e("csrfToken", e.localizedMessage ?: "Error csrfToken IO in GetCsrfTokenUSeCase")
        }
    }
}