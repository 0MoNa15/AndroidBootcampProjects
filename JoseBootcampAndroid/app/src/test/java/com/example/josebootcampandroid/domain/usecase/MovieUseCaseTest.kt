package com.example.josebootcampandroid.domain.usecase

import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.example.josebootcampandroid.repository_mock.MovieUseCaseMock
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test


class MovieUseCaseTest{
    @Test
    fun returnEmptyMovieFromApi() = runBlocking {

        //Arrage
        var parameter = 1
        var listala = listOf<SearchModel>(
            SearchModel("Transformer 1","2007","Shia LaBeouf - Megan Fox - Josh Duhamel", "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=es"),
            SearchModel("La venganza de los caídos","2009","(Frank Welker - John Turturro - Ramon Rodriguez",""),
            SearchModel("El lado oscuro de la luna","2011","Rosie Huntington-Whiteley - Patrick Dempsey","")
        )
        val release_date = "2009"

        //Action
        val result = MovieUseCaseMock().getAllMovies(1)

        //Assert

        //assertEquals(result.moviesList[1].release_date, release_date)
        assertEquals(result.moviesList, listala)

    }
}