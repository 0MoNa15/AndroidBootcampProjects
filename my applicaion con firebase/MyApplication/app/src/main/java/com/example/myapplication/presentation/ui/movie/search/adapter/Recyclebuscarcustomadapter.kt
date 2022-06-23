package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.home.adapter.HomeViewHolder
import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import com.example.myapplication.presentation.ui.movie.search.adapter.SearchMovieViewHolder

class recyclebuscarcustomadapter (private val searchmovieList: List<SearchMovie>): RecyclerView.Adapter<SearchMovieViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SearchMovieViewHolder {
        val LayoutInflater = LayoutInflater.from(viewGroup.context)
        return SearchMovieViewHolder(LayoutInflater.inflate(R.layout.recyclebuscar,viewGroup,false))
    }

    override fun onBindViewHolder(viewHolder: SearchMovieViewHolder, i: Int) {
        val item =searchmovieList[i]
        viewHolder.render(item)

    }

    override fun getItemCount(): Int = searchmovieList.size




}