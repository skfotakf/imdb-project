package com.example.imdb.core.database

import com.example.imdb.core.domain.MovieEntity
import com.example.imdb.core.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<MovieEntity, Long> {

}

interface UserRepository: JpaRepository<UserEntity, Long>{

    fun findByEmail(email: String) : UserEntity?
}