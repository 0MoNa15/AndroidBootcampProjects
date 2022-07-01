package com.example.myapplication.domain.repository

import com.example.myapplication.data.home.model.MovieHomeListResponse

interface HomeMovieRepository {

    suspend fun homerepositorygetmovies():MovieHomeListResponse
}