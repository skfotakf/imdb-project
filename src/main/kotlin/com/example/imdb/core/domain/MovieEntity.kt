package com.example.imdb.core.domain

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

){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

}