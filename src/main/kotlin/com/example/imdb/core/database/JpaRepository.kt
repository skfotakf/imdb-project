package com.example.imdb.core.database

import com.example.imdb.core.domain.MovieEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<MovieEntity, Long> {
}