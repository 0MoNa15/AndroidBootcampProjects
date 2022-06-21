package com.example.alejobootcampandroid.domain.movie.model

import java.io.Serializable


data class MovieModel(
    val title: String,
    val backdrop_path: String,
    val poster_path: String,
    val release_date: String,
    val protagonist:String,
    val original_title: String,
    val overview: String,
    val vote_average: Number
    ): Serializable
