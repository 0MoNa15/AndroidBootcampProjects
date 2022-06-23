package com.example.myapplication.data.home.model

import com.google.gson.annotations.SerializedName

data class MovieHomeListResponse(@SerializedName("results")
                             var moviesList: List<MovieHome>
                             )
