package com.example.imdb.core.api.controller

import com.example.imdb.core.api.request.LoginRequest
import com.example.imdb.core.api.request.SignupRequest
import com.example.imdb.core.database.UserRepository
import com.example.imdb.core.service.AuthService
import com.example.imdb.core.service.AuthToken
import org.springframework.stereotype.Controller
import jakarta.validation.Valid
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception


@Controller
@RequestMapping("/auth")
class AuthController(
        private val authService: AuthService,
        private val userRepository: UserRepository
) {

    @GetMapping("/signup")
    fun signupForm(model: Model): String {
        model.addAttribute("signupRequest", SignupRequest("","","","","","role"))
        return "auth/signup"
    }
    @PostMapping("/signup")
    fun signup(@Valid signupRequest: SignupRequest, bindingResult: BindingResult) : String? {

        if(userRepository.findByEmail(signupRequest.email) != null) {
            bindingResult.rejectValue("email", "key", "이미 가입되어 있는 이메일입니다")
        }
        if(signupRequest.password != signupRequest.repassword){
            bindingResult.rejectValue("repassword", "key","비밀번호가 일치하지 않습니다")
        }
        if(bindingResult.hasErrors()){

            return "auth/signup"
        }
        authService.signup(signupRequest)
        return "redirect:/auth/login"
    }

    @GetMapping("/login")
    fun loginForm(model: Model, @RequestParam(value="error", required=false)error: String?,
                  @RequestParam(value="exc") exc: String?) : String{
        model.addAttribute("error")
        model.addAttribute("exc",exc)
        val loginRequest : LoginRequest = LoginRequest("","")
        model.addAttribute("loginRequest",loginRequest)
        println(loginRequest.email)
        return "auth/login"
    }

    /*
    @PostMapping("/login")
    fun login(@Valid loginRequest: LoginRequest, bindingResult: BindingResult): String? {
        println("2")
        authService.login(loginRequest)
        return "redirect:/chart/top"
    }

     */






}