package com.example.imdb.config

import com.example.imdb.common.IMDb403
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.InsufficientAuthenticationException
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.stereotype.Component
import java.io.IOException


@Component
class CustomAuthFailureHandler : SimpleUrlAuthenticationFailureHandler() {
    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(request: HttpServletRequest?, response: HttpServletResponse?, exception: AuthenticationException?) {

        var exceptionMessage = "loginError" // 기본 예외 메시지

        // exception 처리

        if (exception is BadCredentialsException) {
            exceptionMessage = "wrongPassword"
        } else if (exception is UsernameNotFoundException) {
            exceptionMessage = "wrongId"
        }
        else if (exception is InsufficientAuthenticationException) {
            exceptionMessage = "loginError"
        }
        // 파라미터로 error와 exception을 보내서 controller에서 처리하기 위함.
        setDefaultFailureUrl("/auth/login?error=true&exc=$exceptionMessage")

        // 부모클래스의 onAuthenticationFailure로 처리를 위임하자.
        super.onAuthenticationFailure(request, response, exception)
    }


}