package com.example.josebootcampandroid.repository_mock

import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.data.home.ListMovieProfileModel
import com.example.josebootcampandroid.data.movie.models.MovieListResponse
import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.example.josebootcampandroid.domain.repositories.MovieRepository

class MovieUseCaseMock : MovieRepository {

    override suspend fun getAllMovies(listId : Int?): MovieListResponse {

        var movielistresponse = MovieListResponse(emptyList())

        when (listId) {
            1 -> {
                var listala = listOf<SearchModel>(
                    SearchModel("Transformer 1","2007","Shia LaBeouf - Megan Fox - Josh Duhamel", "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=es"),
                    SearchModel("La venganza de los caídos","2009","(Frank Welker - John Turturro - Ramon Rodriguez",""),
                    SearchModel("El lado oscuro de la luna","2011","Rosie Huntington-Whiteley - Patrick Dempsey","")
                )
                movielistresponse = MovieListResponse(listala)
            }
            2 -> {
                movielistresponse = MovieListResponse(listOf())
            }
        }
        return movielistresponse
    }


}