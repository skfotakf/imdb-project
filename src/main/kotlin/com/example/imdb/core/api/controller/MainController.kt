package com.example.imdb.core.api.controller

import com.example.imdb.core.service.movieService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView


@Controller
@RequestMapping("/chart")
class MainController(
        private val movieService: movieService

) {
    @GetMapping("/")
    fun indexRedirectHandler(): String {
        return "redirect:top"
    }

    @GetMapping("/top")
    fun chart(): ModelAndView {

        val mav = ModelAndView("chart/top")
        mav.addObject("chartAllTop",movieService.getChartAll())
        return mav

    }


}