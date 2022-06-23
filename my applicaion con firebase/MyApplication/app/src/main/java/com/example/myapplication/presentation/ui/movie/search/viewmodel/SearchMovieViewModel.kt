package com.example.myapplication.presentation.ui.movie.search.viewmodel

import android.widget.Toast
import androidx.lifecycle.*
import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.home.model.MovieHome
import com.example.myapplication.data.source.ApiRestManager
import com.example.myapplication.presentation.ui.movie.search.SearchMovieFragment
import com.example.myapplication.presentation.ui.movie.search.SearchmovieProvider
import com.example.myapplication.presentation.ui.movie.search.searchinterface.APIservice
import com.example.myapplication.view.recyclebuscarcustomadapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SearchMovieViewModel : ViewModel(){
    private val _searchhomemovies = MutableLiveData<List<SearchMovie>>()
    val searchhomemovies: LiveData<List<SearchMovie>>
        get()= _searchhomemovies

    fun getsearchhomemovies(){
        viewModelScope.launch {
            try {
                val response = ApiRestManager.create().getMovie(1,ApiRestManager.apiKey)
                _searchhomemovies.value = response.searchmoviesList

            } catch (e: Exception){

            }




        }
    }

// The internal MutableLiveData that stores the status of the most recent request
  /*  private val dogImages = mutableListOf<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = dogImages
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        private fun searchByname(query:String){
            CoroutineScope(Dispatchers.IO).launch{
                val call=getRetrofit().create(APIservice::class.java).getmoviesbyname("$query/images")
                val movies =call.body()



                activity?.runOnUiThread{
                    if(call.isSuccessful){
                        val images =movies?.images ?: emptyList()
                        dogImages.clear()
                        dogImages.addAll(images)
                        adapter.notifyDataSetChanged()
                    }else{
                        showError()
                    }
                }

            }

        }
    }

    private fun initRecyclerView() {
        adapter = recyclebuscarcustomadapter(dogImages)
        binding.recyclerViewbuscar.layoutManager= LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL ,false)
        binding.recyclerViewbuscar.adapter = adapter
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByname(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun showError() {
        Toast.makeText(activity,"fallo", Toast.LENGTH_SHORT).show()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }*/


}