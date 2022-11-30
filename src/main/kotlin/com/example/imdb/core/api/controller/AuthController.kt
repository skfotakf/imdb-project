package com.example.imdb.core.api.controller

import com.example.imdb.core.api.request.SignupRequest
import com.example.imdb.core.service.AuthService
import com.example.imdb.core.service.AuthToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import jakarta.validation.Valid


@Controller
@RequestMapping("/auth")
class AuthController(
        private val authService: AuthService
) {

    @GetMapping("/signup")
    fun signupForm(): String {
        return "auth/signup"
    }
    @PostMapping("/signup")
    fun signup(@Valid signupRequest: SignupRequest) : AuthToken? {

        return authService.signup(signupRequest)
    }


}