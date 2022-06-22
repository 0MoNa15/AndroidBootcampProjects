package com.example.myapplication.data.source

import com.example.myapplication.data.home.model.MovieHomeListResponse
import com.example.myapplication.data.movie.search.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitMovieDataSource {
    @GET("list/{id}")
    suspend fun getMovie(
        @Path("id")listId:Int?,
        @Query("api_key")apiKey:String?
    ): MovieListResponse

    @GET("movie/top_rated")
    suspend fun getmovierated(
        @Query("api_key") apiKey: String?
    ): MovieHomeListResponse

}