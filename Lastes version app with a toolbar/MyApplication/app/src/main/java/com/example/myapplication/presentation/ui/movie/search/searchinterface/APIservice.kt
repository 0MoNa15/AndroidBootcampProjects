package com.example.myapplication.presentation.ui.movie.search.searchinterface

import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    @GET()
    suspend fun getmoviesbyname(@Url url: String):Response<SearchMovie>
}

