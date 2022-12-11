package com.example.imdb.common

import org.springframework.http.HttpStatus

open class IMDbException(msg: String, val status: HttpStatus) : RuntimeException(msg)

class IMDb404(msg: String) : IMDbException(msg, HttpStatus.NOT_FOUND)

class IMDb400(msg: String) : IMDbException(msg, HttpStatus.BAD_REQUEST)

class IMDb409(msg: String) : IMDbException(msg, HttpStatus.CONFLICT)

class IMDb401(msg: String) : IMDbException(msg, HttpStatus.UNAUTHORIZED)

class IMDb403(msg: String) : IMDbException(msg, HttpStatus.FORBIDDEN)