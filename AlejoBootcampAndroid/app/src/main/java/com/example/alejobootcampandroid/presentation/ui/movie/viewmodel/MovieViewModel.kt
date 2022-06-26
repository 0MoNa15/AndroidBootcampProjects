package com.example.alejobootcampandroid.presentation.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.app.MovieApiStatus
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.use_case.movie.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel(){

    private val _movie = MutableLiveData<List<MovieModel>>()
    val movie: LiveData<List<MovieModel>>
        get() = _movie

    private val _status = MutableLiveData<MovieApiStatus>()
    val status : LiveData<MovieApiStatus>
        get() = _status


    fun getMoviesFromRepository(){
        _status.value = MovieApiStatus.LOADING
        viewModelScope.launch {
            try {
                val listResult = getMoviesUseCase()
                _movie.value = listResult.moviesList
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
                _movie.value = listOf()
            }
        }
    }


}