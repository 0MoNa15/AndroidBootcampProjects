package com.example.myapplication.domain.repository.Mock

import com.example.myapplication.data.movie.search.MovieListResponse

interface MovieRepositoryMock {
    suspend fun repositorygetmovies(listId:Int): MovieListResponse
}