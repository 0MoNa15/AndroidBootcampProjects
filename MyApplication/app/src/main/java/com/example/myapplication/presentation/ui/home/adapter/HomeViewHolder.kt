package com.example.myapplication.presentation.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.movie.Movie
import com.example.myapplication.databinding.CardLayoutBinding


class HomeViewHolder (view: View):RecyclerView.ViewHolder(view){

    val binding = CardLayoutBinding.bind(view)

    fun render(movieModel: Movie){
        binding.itemTitle.text =movieModel.title
        binding.itemDetal.text = movieModel.description
        Glide.with(binding.itemImage.context).load(movieModel.imageUrl).into(binding.itemImage)
    }

}