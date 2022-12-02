package com.example.imdb.core.service

import com.example.imdb.core.api.request.SignupRequest
import com.example.imdb.core.database.UserRepository
import com.example.imdb.core.domain.UserEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
        private val userRepository: UserRepository,
        private val authTokenService: AuthTokenService,
        private val passwordEncoder: PasswordEncoder
) {

    fun signup(signupRequest: SignupRequest) : AuthToken?{

        val encodedPassword = this.passwordEncoder.encode(signupRequest.password)
        userRepository.save(UserEntity.of(signupRequest, encodedPassword))
        return authTokenService.generateTokenByEmail(signupRequest.email)

    }

}