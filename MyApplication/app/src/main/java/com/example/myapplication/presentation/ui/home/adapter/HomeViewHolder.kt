package com.example.myapplication.presentation.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.home.model.MovieHome
import com.example.myapplication.databinding.CardLayoutBinding


class HomeViewHolder (view: View):RecyclerView.ViewHolder(view){

    val binding = CardLayoutBinding.bind(view)

    fun render(movieModel: MovieHome){
        binding.itemTitle.text =movieModel.title
        binding.itemDetal.text = movieModel.vote_average.toString()
        Glide.with(binding.itemImage.context).load("https://image.tmdb.org/t/p/w500${movieModel.backdrop_path}").into(binding.itemImage)
    }

}