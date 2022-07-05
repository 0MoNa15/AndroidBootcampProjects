package com.example.josebootcampandroid.data.repositories

import com.example.josebootcampandroid.data.home.ListMovieResponse
import com.example.josebootcampandroid.data.source.RetrofitMovieDataSource
import com.example.josebootcampandroid.di.ApiRestManager
import com.example.josebootcampandroid.domain.repositories.MovieHomeRepository
import javax.inject.Inject

class MovieHomeRepositoryImpl @Inject constructor(private val api : RetrofitMovieDataSource) :
    MovieHomeRepository {
    override suspend fun getAllHomeMovies(): ListMovieResponse {
        return api.obtainMovieList(ApiRestManager.apiKey)
    }
}