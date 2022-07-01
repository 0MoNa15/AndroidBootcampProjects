package com.example.myapplication.data.repository

import com.example.myapplication.data.home.model.MovieHomeListResponse
import com.example.myapplication.data.source.RetrofitMovieDataSource
import com.example.myapplication.di.ApiRestManager
import com.example.myapplication.domain.repository.HomeMovieRepository
import javax.inject.Inject

class HomeMovieRepositoryImpl @Inject constructor (private val api : RetrofitMovieDataSource) : HomeMovieRepository {
    override suspend fun homerepositorygetmovies(): MovieHomeListResponse {
        return api.getmovierated(ApiRestManager.apiKey)
    }
}