package com.example.myapplication.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

import com.example.myapplication.data.home.model.MovieHome

class CustomAdapter (private val homemovieslistglobal:List<MovieHome>) : RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HomeViewHolder {
        val LayoutInflater = LayoutInflater.from(viewGroup.context)
        return HomeViewHolder(LayoutInflater.inflate(R.layout.card_layout,viewGroup,false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item =homemovieslistglobal[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = homemovieslistglobal.size


}