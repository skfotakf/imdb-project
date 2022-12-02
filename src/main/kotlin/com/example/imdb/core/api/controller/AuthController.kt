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
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.servlet.ModelAndView


@Controller
@RequestMapping("/auth")
class AuthController(
        private val authService: AuthService
) {

    @GetMapping("/signup")
    fun signupForm(model: Model): String {
        model.addAttribute("signupRequest", SignupRequest("","","","","","role"))
        return "auth/signup"
    }
    @PostMapping("/signup")
    fun signup(@Valid signupRequest: SignupRequest, bindingResult: BindingResult) : String? {

        if(signupRequest.password != signupRequest.repassword){
            bindingResult.rejectValue("repassword", "key","비밀번호가 일치하지 않습니다")
        }
        if(bindingResult.hasErrors()){

            return "auth/signup"
        }
        authService.signup(signupRequest)
        return "redirect:/chart/top"
    }


}