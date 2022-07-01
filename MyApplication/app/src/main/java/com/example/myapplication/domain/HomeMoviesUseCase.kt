package com.example.myapplication.domain

import com.example.myapplication.domain.repository.HomeMovieRepository
import javax.inject.Inject

class HomeMoviesUseCase @Inject constructor(private val homeMovieRepository: HomeMovieRepository) {

    suspend operator fun invoke () = homeMovieRepository.homerepositorygetmovies()
}