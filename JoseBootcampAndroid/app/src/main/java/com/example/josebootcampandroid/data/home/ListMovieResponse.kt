package com.example.josebootcampandroid.data.home


import com.google.gson.annotations.SerializedName

data class ListMovieResponse (
    @SerializedName("results")
    var HomeMoviesList: List<ListMovieProfileModel>
    )