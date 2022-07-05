package com.example.josebootcampandroid.data.movie.models

import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("items")
    var moviesList: List<SearchModel>
)