package com.example.myapplication.domain.repository

import com.example.myapplication.domain.repository.Mock.MovieRepositoryMock
import javax.inject.Inject

class MoviesUseCaseMock @Inject constructor(private val movieRepository: MovieRepositoryMock )  {
    suspend operator fun invoke () = movieRepository.repositorygetmovies(1)


}