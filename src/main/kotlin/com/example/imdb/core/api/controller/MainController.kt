package com.example.imdb.core.api.controller

import com.example.imdb.core.service.MovieService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/chart")
class MainController(
        private val movieService: MovieService

) {
    @GetMapping("/")
    fun indexRedirectHandler(): String {
        return "redirect:/top"
    }

    @GetMapping("/top")
    fun chart(model: Model): String {
        model.addAttribute("chartAllTop",movieService.getChartAll())
        return "chart/top"

    }

    @GetMapping("/sec")
    fun sec(): String {


        return "chart/sec"

    }


}