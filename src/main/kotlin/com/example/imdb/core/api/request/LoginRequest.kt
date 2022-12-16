package com.example.imdb.core.api.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class LoginRequest(
        @field:NotBlank(message = "해당 정보가 없습니다")
        @field:Email(message = "이메일 형식에 맞게 입력해야 합니다")
        val email: String,

        @field:Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어 또는 숫자를 넣어서 6~12자리 이내로 입력해주세요.")
        val password: String?,

        


)