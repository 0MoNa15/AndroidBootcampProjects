package com.example.josebootcampandroid.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.josebootcampandroid.data.home.ListMovieProfileModel
import com.example.josebootcampandroid.di.ApiRestManager
import com.example.josebootcampandroid.domain.usecase.MovieHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieHomeUseCase: MovieHomeUseCase) : ViewModel() {
    private  val _homeMovie = MutableLiveData<List<ListMovieProfileModel>>()
    val homeMovie: LiveData<List<ListMovieProfileModel>>
    get() = _homeMovie

    fun fromApi(){
        viewModelScope.launch {
            //val response = ApiRestManager.create().obtainMovieList(ApiRestManager.apiKey)
            try {
                val response = movieHomeUseCase()
                _homeMovie.value = response.HomeMoviesList
            }catch (e:Exception){
            Log.i("R","Error presentado")
            }
        }
    }

    /*private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text*/
}