package com.example.myapplication.presentation.ui.movie.search.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.RecyclebuscarBinding
import com.example.myapplication.presentation.ui.movie.search.SearchMovie

class SearchMovieViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = RecyclebuscarBinding.bind(view)

    fun render (searchMovieModel: SearchMovie){
        binding.textViewtitulo.text = searchMovieModel.titles
        binding.textViewyear.text = searchMovieModel.details
        binding.textViewactors.text = searchMovieModel.actors
        Glide.with(binding.imagepeli.context).load(searchMovieModel.images).into(binding.imagepeli)
    }

}