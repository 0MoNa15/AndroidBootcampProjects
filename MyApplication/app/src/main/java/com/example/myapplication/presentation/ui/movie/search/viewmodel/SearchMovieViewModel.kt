package com.example.myapplication.presentation.ui.movie.search.viewmodel

import androidx.lifecycle.*
import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.MovieRepositoryImpl
import com.example.myapplication.di.ApiRestManager
import com.example.myapplication.domain.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase): ViewModel(){

    private val _searchhomemovies = MutableLiveData<List<SearchMovie>>()
    val searchhomemovies: LiveData<List<SearchMovie>>
        get()= _searchhomemovies

    fun getsearchhomemovies(){
        viewModelScope.launch {
            try {
               // val response = ApiRestManager.create().getMovie(1, ApiRestManager.apiKey)
                val response = moviesUseCase()
                _searchhomemovies.value = response.searchmoviesList

            } catch (e: Exception){

            }
        }
    }
}