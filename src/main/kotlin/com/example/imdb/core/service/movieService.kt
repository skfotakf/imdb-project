package com.example.imdb.core.service

import com.example.imdb.core.database.MovieRepository
import org.springframework.stereotype.Service

@Service
class movieService(
        private val movieRepository: MovieRepository
) {

    fun getChartAll(){
        movieRepository.findAll()
    }
}