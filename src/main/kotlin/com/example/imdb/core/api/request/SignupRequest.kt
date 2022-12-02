package com.example.imdb.core.api.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern

data class SignupRequest(
        @field:NotBlank(message = "해당 정보가 없습니다")
        @field:Email(message = "이메일 형식에 맞게 입력해야 합니다")
        val email: String,

        @field:Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어 또는 숫자를 넣어서 6~12자리 이내로 입력해주세요.")
        val password: String?,

        @field:Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어 또는 숫자를 넣어서 6~12자리 이내로 입력해주세요.")
        val repassword: String?,

        @field:NotBlank(message = "해당 정보가 없습니다")
        val nickname: String?,

        @field:NotNull
        @field:Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "012-3456-7890로 입력해야 합니다")
        val telephone: String?,

        val role: String?


)