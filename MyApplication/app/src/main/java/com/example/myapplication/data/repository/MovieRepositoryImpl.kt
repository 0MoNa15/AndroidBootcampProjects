package com.example.myapplication.data.repository

import com.example.myapplication.data.movie.search.MovieListResponse
import com.example.myapplication.data.source.RetrofitMovieDataSource
import com.example.myapplication.di.ApiRestManager
import com.example.myapplication.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (private val api : RetrofitMovieDataSource) : MovieRepository {


    override suspend fun repositorygetmovies(): MovieListResponse {
        return api.getMovie(1,ApiRestManager.apiKey)
    }


}