package com.example.imdb.core.service

import com.example.imdb.common.IMDb400
import com.example.imdb.core.api.request.LoginRequest
import com.example.imdb.core.api.request.SignupRequest
import com.example.imdb.core.database.UserRepository
import com.example.imdb.core.domain.UserEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AuthService(
        private val userRepository: UserRepository,
        private val authTokenService: AuthTokenService,
        private val passwordEncoder: PasswordEncoder

) {

    fun signup(signupRequest: SignupRequest) : AuthToken?{
        if (userRepository.findByEmail(signupRequest.email) != null) {
            throw IMDb400("해당 이메일은 이미 가입되어 있습니다")
        }
        val encodedPassword = this.passwordEncoder.encode(signupRequest.password)
        userRepository.save(UserEntity.of(signupRequest, encodedPassword))
        return authTokenService.generateTokenByEmail(signupRequest.email)

    }
/*
    fun login(loginRequest: LoginRequest) : AuthToken? {
        val user = userRepository.findByEmail(loginRequest.email) ?: throw Seminar400("오류")
        if (loginRequest.password == user.password) {
            return authTokenService.generateTokenByEmail(loginRequest.email)

        } else {
            throw Seminar400("로그인 실패")
        }
    }


 */


}