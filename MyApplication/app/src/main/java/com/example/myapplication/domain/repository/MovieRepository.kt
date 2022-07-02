package com.example.myapplication.domain.repository

import com.example.myapplication.data.home.model.MovieTest
import com.example.myapplication.data.movie.search.MovieListResponse

interface MovieRepository {

    suspend fun repositorygetmovies(listId:Int): MovieListResponse
    //suspend fun repositorygetmovies(): MovieListResponse // No panic just earase the line above
}