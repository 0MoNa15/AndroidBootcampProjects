package com.example.myapplication.domain

import com.example.myapplication.domain.repository.MovieRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val movieRepository: MovieRepository )  {
 suspend operator fun invoke () = movieRepository.repositorygetmovies(1)
 //suspend operator fun invoke () = movieRepository.repositorygetmovies()

}