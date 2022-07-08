package com.example.josebootcampandroid.domain.usecase

import com.example.josebootcampandroid.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    //suspend operator fun invoke() = movieRepository.getAllMovies(1)
    suspend operator fun invoke() = movieRepository.getAllMovies(1)
}
