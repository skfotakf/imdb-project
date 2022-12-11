package com.example.imdb.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
class AuthConfig(
        private val customAuthFailureHandler: CustomAuthFailureHandler,

){

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }
    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {

        return httpSecurity.csrf().disable().authorizeHttpRequests().anyRequest().permitAll().and().formLogin()

                .loginPage("/auth/login")
                .loginProcessingUrl("/auth/login")  // 로그인 Form Action Url
                .defaultSuccessUrl("/chart/top")
                .failureHandler(customAuthFailureHandler).and().build() // 로그인 실패 후 핸들러.and().build()

    }


}

