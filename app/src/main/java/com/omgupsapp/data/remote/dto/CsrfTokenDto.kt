package com.omgupsapp.data.remote.dto

import com.omgupsapp.domain.model.CsrfToken

data class CsrfTokenDto (
    val csrfToken: String
)

fun CsrfTokenDto.toCsrfToken(): CsrfToken {
    return CsrfToken(
        csrfToken = csrfToken
    )
}