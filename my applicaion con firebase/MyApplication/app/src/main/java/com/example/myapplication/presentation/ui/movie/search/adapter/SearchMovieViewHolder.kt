package com.example.myapplication.presentation.ui.movie.search.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.RecyclebuscarBinding
import com.example.myapplication.presentation.ui.movie.search.SearchMovie
import com.squareup.picasso.Picasso

class SearchMovieViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = RecyclebuscarBinding.bind(view)

    fun render (searchMovieModel: SearchMovie){
        binding.textViewtitulo.text = searchMovieModel.title
        binding.textViewyear.text = searchMovieModel.release_date
        binding.textViewactors.text = searchMovieModel.original_title
        Glide.with(binding.imagepeli.context).load("https://image.tmdb.org/t/p/w500${searchMovieModel.backdrop_path}").into(binding.imagepeli)
    }
    /*fun bind(image:String){
        Picasso.get().load(image).into(binding.imagepeli)
    }*/

}