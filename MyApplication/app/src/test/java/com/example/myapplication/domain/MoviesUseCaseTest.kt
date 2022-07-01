package com.example.myapplication.domain

import com.example.myapplication.data.movie.search.MovieListResponse
import com.example.myapplication.domain.repository.MovieRepository
import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class MoviesUseCaseTest{

    @RelaxedMockK
    private lateinit var movierepository: MovieRepository

    lateinit var moviesUseCase: MoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        moviesUseCase = MoviesUseCase(movierepository)
    }

    @Test
fun receivingsomethingfromapi()= runBlocking {
    //given
        var myList = listOf(SearchMovie("Arrow",200,"Stephen Amel","x=es","hola","hi","hi","ji"))

    coEvery { movierepository.repositorygetmovies().searchmoviesList } returns emptyList()

        //When
        MoviesUseCase(movierepository)
        //then
    coVerify { MoviesUseCase(movierepository) }
    }



}