package com.example.imdb.core.api.request

import jakarta.validation.constraints.NotBlank

data class SignupRequest(
      //  @field:NotBlank(message = "해당 정보가 없습니다")
        val email: String?,

        //@field:NotBlank(message = "해당 정보가 없습니다")
        val password: String?,

        //@field:NotBlank(message = "해당 정보가 없습니다")
        val nickname: String?,

        val telephone: String?,

        val role: String?


) {
}