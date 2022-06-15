package com.example.myapplication.data.movie.models

import com.example.myapplication.data.movie.Movie
import com.google.gson.annotations.SerializedName

class MovieListResponse {
    data class MovieListResponse(
        @SerializedName("items")
        var moviesList: List<Movie>
    )
}