package com.example.imdb.core.service

import com.example.imdb.common.IMDb403
import com.example.imdb.core.database.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class BackedLoginService(

        private val userRepository: UserRepository
):UserDetailsService{


    override fun loadUserByUsername(username: String?): UserDetails {
        println(username?.length)
        val roles: MutableCollection<SimpleGrantedAuthority> = ArrayList()
        roles.add(SimpleGrantedAuthority("ROLE_USER"))

        println(username?.length)
        val user = username?.let { userRepository.findByEmail(it) } ?: throw UsernameNotFoundException("존재하지 않는 이메일입니다")
        return User(user.email, user.password,roles)
    }

}