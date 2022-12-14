package com.example.imdb.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class SeminarExceptionHandler {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handle(e: MethodArgumentNotValidException): ResponseEntity<Any> {
        val bindingResult: BindingResult = e.bindingResult
        return ResponseEntity(bindingResult.fieldError?.defaultMessage, HttpStatus.BAD_REQUEST)
    }
    
 

    @ExceptionHandler(value = [IMDbException::class])
    fun handle(e: IMDbException): ResponseEntity<Any> {
        return ResponseEntity(e.message, e.status)
    }
}