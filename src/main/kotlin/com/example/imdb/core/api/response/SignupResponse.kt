package com.example.imdb.core.api.response


data class SignupResponse(

        val email: String?,

        val password: String?,

        val nickname: String?,

        val telephone: String?,

        val role: String?
) {
}