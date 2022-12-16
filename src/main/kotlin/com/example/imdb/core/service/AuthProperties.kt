package com.example.imdb.core.service

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@ConfigurationProperties
data class AuthProperties(
        val issuer: String ="TEST",
        val jwtSecret: String ="SEMINAR_SECRET_KEYfkrhsksmsakfgoTekdkfrpTsi",
        val jwtExpiration: Long =86400,
) {

}