package com.example.myapplication.data.movie.search


import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import com.google.gson.annotations.SerializedName

class MovieListResponse (@SerializedName("items")
                         var searchmoviesList: List<SearchMovie>
)
