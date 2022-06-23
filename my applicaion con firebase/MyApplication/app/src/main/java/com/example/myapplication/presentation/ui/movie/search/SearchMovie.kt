package com.example.myapplication.presentation.ui.movie.search

import com.google.gson.annotations.SerializedName

data class SearchMovie (

        val overview: String,
        val vote_average: Number,
        val id: String,
        val backdrop_path: String,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val original_title: String
        )