package com.example.josebootcampandroid.domain.repositories

import com.example.josebootcampandroid.data.home.ListMovieResponse


interface MovieHomeRepository {
    suspend fun getAllHomeMovies(): ListMovieResponse
}