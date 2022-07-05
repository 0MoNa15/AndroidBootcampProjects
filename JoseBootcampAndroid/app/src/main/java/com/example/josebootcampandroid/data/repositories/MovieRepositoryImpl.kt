package com.example.josebootcampandroid.data.repositories

import com.example.josebootcampandroid.data.movie.models.Movie
import com.example.josebootcampandroid.data.movie.models.MovieListResponse
import com.example.josebootcampandroid.data.source.RetrofitMovieDataSource
import com.example.josebootcampandroid.di.ApiRestManager
import com.example.josebootcampandroid.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (private val api : RetrofitMovieDataSource) :
    MovieRepository {
    override suspend fun getAllMovies(listId : Int?): MovieListResponse {
        return api.obtainMovie(1,ApiRestManager.apiKey)
    }

}