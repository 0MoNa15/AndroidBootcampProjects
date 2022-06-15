package com.example.myapplication.domain.repositories

import com.example.myapplication.data.movie.Movie

interface MovieRepository {
    fun getAllMovies(): List<Movie>

}