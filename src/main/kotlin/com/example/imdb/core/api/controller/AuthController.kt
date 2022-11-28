package com.example.imdb.core.api.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller("/auth")
class AuthController {

    @GetMapping("/signup")
    fun signupForm(): String? {
        return "auth/signup"
    }

    

}