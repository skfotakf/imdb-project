package com.example.imdb.core.service

import com.example.imdb.core.database.MovieRepository
import com.example.imdb.core.domain.MovieEntity
import org.springframework.stereotype.Service
import org.springframework.web.servlet.ModelAndView

@Service
class movieService(
        private val movieRepository: MovieRepository
) {

    fun getChartAll() : List<MovieEntity>{
        return movieRepository.findAll()

    }
}