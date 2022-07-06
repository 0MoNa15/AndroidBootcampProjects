package com.example.myapplication.presentation.ui.movie.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentSearchmovieBinding
import com.example.myapplication.presentation.ui.home.HomeViewModel
import com.example.myapplication.presentation.ui.home.adapter.CustomAdapter
import com.example.myapplication.presentation.ui.movie.search.adapter.SearchMovieViewHolder
import com.example.myapplication.presentation.ui.movie.search.searchinterface.APIservice
import com.example.myapplication.presentation.ui.movie.search.viewmodel.SearchMovieViewModel
import com.example.myapplication.view.recyclebuscarcustomadapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Query
import retrofit2.converter.moshi.MoshiConverterFactory
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [buscarpel.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SearchMovieFragment : Fragment() {
//SearchView.OnQueryTextListener
    private lateinit var adapter: recyclebuscarcustomadapter

    private var _binding: FragmentSearchmovieBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchmovieBinding.inflate(inflater)
        val view = binding.root

        val searchViewModel = ViewModelProvider(this).get(SearchMovieViewModel::class.java)

        searchViewModel.getsearchhomemovies()
        searchViewModel.searchhomemovies.observe(viewLifecycleOwner,Observer{
            binding.recyclerViewbuscar.apply{
                layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL ,false)
                adapter= recyclebuscarcustomadapter(it)
            }
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


