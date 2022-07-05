package com.example.josebootcampandroid.domain.repositories

import com.example.josebootcampandroid.data.movie.models.Movie
import com.example.josebootcampandroid.data.movie.models.MovieListResponse

interface MovieRepository {
    //suspend fun getAllMovies(): MovieListResponse
    suspend fun getAllMovies(listId : Int?): MovieListResponse
}