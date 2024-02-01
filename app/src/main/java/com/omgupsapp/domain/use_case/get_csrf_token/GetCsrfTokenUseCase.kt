package com.omgupsapp.domain.use_case.get_csrf_token

import com.omgupsapp.common.Resource
import com.omgupsapp.data.remote.dto.toCsrfToken
import com.omgupsapp.domain.model.CsrfToken
import com.omgupsapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCsrfTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(): Flow<Resource<CsrfToken>> = flow {
        try {
            emit(Resource.Loading())
            val csrfToken = repository.getСsrfToken().toCsrfToken()
            emit(Resource.Success(csrfToken))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Ошибка в http "))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Проверьте свое подключение к интернету"))
        }
    }
}