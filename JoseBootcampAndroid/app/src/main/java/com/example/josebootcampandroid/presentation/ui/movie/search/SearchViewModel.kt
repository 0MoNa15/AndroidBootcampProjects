package com.example.josebootcampandroid.presentation.ui.movie.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.example.josebootcampandroid.di.ApiRestManager
import com.example.josebootcampandroid.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {
    private var _searchMovieList = MutableLiveData<List<SearchModel>>()
    val searchMovieList : LiveData<List<SearchModel>>
    get() = _searchMovieList

    private val _status = MutableLiveData<String>()
    val status : LiveData<String>
    get() = _status

//    fun getSearchMovieList(){
//        _searchMovieList.value = SearchProvider.SearchOfMovie
//    }

    private var movieUnique = emptyList<SearchModel>()

    fun searchMovieByTitle(movieSearch: String){
        if(movieSearch.isNotEmpty()){
            _searchMovieList.value = movieUnique.filter { searchMovieList ->
                searchMovieList.title.lowercase().contains(movieSearch.lowercase())
            }
        }
        else {
            _searchMovieList.postValue(movieUnique)
        }
    }

    fun fromApi(){
        viewModelScope.launch {
            try {
                //val response = ApiRestManager.create().obtainMovie(1, ApiRestManager.apiKey)
                val response = movieUseCase()
                _searchMovieList.value = response.moviesList
                movieUnique = response.moviesList
            }catch (e:Exception){
                _status.value = e.message
            }
        }
    }
}