package com.example.myapplication.data.source

import com.example.myapplication.data.movie.models.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitMovieDataSource {

    @GET("list/{id}")
    fun getMoviesList(
        @Path("id") listId : Int?,
        @Query("api_key") apiKey: String?
    ): MovieListResponse


}