package com.example.myapplication

import com.example.myapplication.data.movie.search.MovieListResponse
import com.example.myapplication.domain.repository.MovieRepository
import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : MovieRepository{

    override suspend fun repositorygetmovies(listId:Int): MovieListResponse {

        var movielistresponse = MovieListResponse(emptyList())

        when(listId){
            1-> {
                var lalista = listOf<SearchMovie>(
                    SearchMovie("Arrow",1,"2008","Stephen Amel","https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=es","","",""),
                    SearchMovie("Yo soy Betty la fea",2,"1999","Jorge Enrique y Ana Orozco","https://www.okchicas.com/wp-content/uploads/2022/06/Yo-soy-Betty-la-fea-sale-de-Netflix-y-desato-epicos-memes.jpg","","",""),
                    SearchMovie("The queen of flow",3,"2020","Tamy Andrade y Charly Flow","https://pbs.twimg.com/media/DxIRyofU0AAGVwY.jpg","","",""),

                )
                movielistresponse = MovieListResponse(lalista)
            }
            2->{
                movielistresponse= MovieListResponse(listOf())
            }
        }
        return movielistresponse
    }


}

