package com.example.myapplication.data.repository

import com.example.myapplication.data.movie.search.MovieListResponse
import com.example.myapplication.data.source.RetrofitMovieDataSource
import com.example.myapplication.di.ApiRestManager
import com.example.myapplication.domain.repository.Mock.MovieRepositoryMock
import com.example.myapplication.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplMock @Inject constructor (private val api : RetrofitMovieDataSource) : MovieRepositoryMock {

    override suspend fun repositorygetmovies(listId:Int): MovieListResponse {
        return api.getMovie(listId, ApiRestManager.apiKey)
    }
}