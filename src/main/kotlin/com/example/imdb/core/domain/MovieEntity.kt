package com.example.imdb.core.domain

import com.example.imdb.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name="Movies")
class MovieEntity(

        @Column
        var title: String?,

        @Column
        var releaseDate: String?,

        @Column
        var viewCnt: Int? =0,

        @Column
        var rating: Float? = 0F,

        @Column
        var ratingCnt: Int? = 0,

        @Column
        var heart: Boolean? = false,

        @Column
        var heartCnt: Int? = 0

):BaseTimeEntity(){


}