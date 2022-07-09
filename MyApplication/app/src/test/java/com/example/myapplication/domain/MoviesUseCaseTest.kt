package com.example.myapplication.domain

import com.example.myapplication.ExampleUnitTest
import com.example.myapplication.data.movie.search.MovieListResponse
import com.example.myapplication.domain.repository.Mock.MovieRepositoryMock
import com.example.myapplication.domain.repository.MovieRepository
import com.example.myapplication.domain.repository.MoviesUseCaseMock
import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MoviesUseCaseTest {

    @RelaxedMockK
    private lateinit var movierepository: MovieRepositoryMock

    lateinit var moviesUseCase: MoviesUseCaseMock

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        moviesUseCase = MoviesUseCaseMock(movierepository)
    }

    @Test
    fun receivingsomethingfromapi()= runBlocking {

        //Arrage
       var parameter =1
        var lalista = listOf<SearchMovie>(
            SearchMovie("Arrow",1,"2008","Stephen Amel","https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=es","","",""),
            SearchMovie("Yo soy Betty la fea",2,"1999","Jorge Enrique y Ana Orozco","https://www.okchicas.com/wp-content/uploads/2022/06/Yo-soy-Betty-la-fea-sale-de-Netflix-y-desato-epicos-memes.jpg","","",""),
            SearchMovie("The queen of flow",3,"2020","Tamy Andrade y Charly Flow","https://pbs.twimg.com/media/DxIRyofU0AAGVwY.jpg","","",""),
            )
        var vote_averagexpected = 2

        //Action
        var result = ExampleUnitTest().repositorygetmovies(parameter)

        //Assert
        assertEquals( result.searchmoviesList , lalista )
    }

    @Test
    fun CheckingASpecificItemFromMockDatabase()= runBlocking {

        //Arrage
        var parameter =1
        var lalista = listOf<SearchMovie>(
            SearchMovie("Arrow",1,"2008","Stephen Amel","https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=es","","",""),
            SearchMovie("Yo soy Betty la fea",2,"1999","Jorge Enrique y Ana Orozco","https://www.okchicas.com/wp-content/uploads/2022/06/Yo-soy-Betty-la-fea-sale-de-Netflix-y-desato-epicos-memes.jpg","","",""),
            SearchMovie("The queen of flow",3,"2020","Tamy Andrade y Charly Flow","https://pbs.twimg.com/media/DxIRyofU0AAGVwY.jpg","","",""),
        )
        var vote_averagexpected = 2

        //Action
        var result = ExampleUnitTest().repositorygetmovies(parameter)

        //Assert
         assertEquals(  result.searchmoviesList[1].vote_average, vote_averagexpected )
    }

    @Test
     fun WhenDatabaseIsEmptyThenReturnNull() = runBlocking{

        //Arrage
        var parameter =2

        //Action
        var result = ExampleUnitTest().repositorygetmovies(parameter)
        var lalista2 = listOf<SearchMovie>()

        //Assert
        assertEquals( result.searchmoviesList , lalista2 )
}

}
