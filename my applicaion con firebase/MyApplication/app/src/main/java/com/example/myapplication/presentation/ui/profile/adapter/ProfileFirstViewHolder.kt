package com.example.myapplication.presentation.ui.profile.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.RecommendationItemBinding
import com.example.myapplication.presentation.ui.profile.FirstprofileOptions

class ProfileFirstViewHolder (view:View): RecyclerView.ViewHolder(view){

val binding = RecommendationItemBinding.bind(view)


    fun render(firstprofileoptionsModel : FirstprofileOptions){
        binding.textView4.text = firstprofileoptionsModel.title
        binding.textView5.text = firstprofileoptionsModel.information
        binding.textView6.text = firstprofileoptionsModel.option
    }
}