package com.example.myapplication.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.home.model.MovieHome
import com.example.myapplication.di.ApiRestManager
import com.example.myapplication.domain.HomeMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeMoviesUseCase: HomeMoviesUseCase): ViewModel() {

    private val _homemovies = MutableLiveData<List<MovieHome>>()
    val homemovies: LiveData<List<MovieHome>>
    get()=_homemovies

    fun gethomemovies(){
        viewModelScope.launch {
            try {
                val response =homeMoviesUseCase()
                _homemovies.value = response.moviesList
            } catch (e: Exception){

             }
        }
    }

//val response = ApiRestManager.create().getmovierated(ApiRestManager.apiKey)
    // _homemovies.value = response.moviesList

}