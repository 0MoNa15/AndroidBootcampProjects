package com.example.myapplication.domain.repository

import com.example.myapplication.data.home.model.MovieTest
import com.example.myapplication.data.movie.search.MovieListResponse

interface MovieRepository {

    suspend fun repositorygetmovies(): MovieListResponse
//test
suspend fun testgetmovies(): MovieTest
}