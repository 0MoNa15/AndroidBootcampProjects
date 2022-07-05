package com.example.josebootcampandroid.domain.usecase

import com.example.josebootcampandroid.domain.repositories.MovieHomeRepository
import javax.inject.Inject

class MovieHomeUseCase @Inject constructor(private val movieHomeRepository: MovieHomeRepository) {
    suspend operator fun invoke() = movieHomeRepository.getAllHomeMovies()
}