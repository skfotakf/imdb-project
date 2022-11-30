package com.example.imdb.core.service

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.*


@Service
@EnableConfigurationProperties(AuthProperties::class)
class AuthTokenService(
        private val authProperties: AuthProperties,

) {
    private val signingKey = Keys.hmacShaKeyFor(authProperties.jwtSecret.toByteArray())

    fun generateTokenByEmail(email: String) : AuthToken{

        val claims: MutableMap<String, Any> = Jwts.claims().setSubject("access")

        claims["email"] = email

        val now = System.currentTimeMillis()
        val nowDate = Date(now)
        val expireDate = Date(nowDate.time+Duration.ofDays(1).toMillis())
        val result = Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims).setIssuer("test").setIssuedAt(nowDate).setExpiration(expireDate)

                .signWith(signingKey, SignatureAlgorithm.HS256).compact()

        return AuthToken(result)

    }


}