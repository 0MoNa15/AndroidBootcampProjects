package com.example.myapplication.data.home.model

import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import com.google.gson.annotations.SerializedName

class MovieTest (@SerializedName("items")
                 var searchmoviesListtest: List<SearchMovie> )
