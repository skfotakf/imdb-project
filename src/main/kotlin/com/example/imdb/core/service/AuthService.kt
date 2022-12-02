package com.example.imdb.core.service

import com.example.imdb.core.api.request.SignupRequest
import com.example.imdb.core.database.UserRepository
import com.example.imdb.core.domain.UserEntity
import org.springframework.stereotype.Service

@Service
class AuthService(
        private val userRepository: UserRepository,
        private val authTokenService: AuthTokenService
) {

    fun signup(signupRequest: SignupRequest) : AuthToken?{
        userRepository.save(UserEntity.of(signupRequest))
        return authTokenService.generateTokenByEmail(signupRequest.email)

    }

}