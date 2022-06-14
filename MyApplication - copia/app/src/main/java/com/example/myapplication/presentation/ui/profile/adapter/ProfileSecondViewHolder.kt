package com.example.myapplication.presentation.ui.profile.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListaPerfilBinding
import com.example.myapplication.databinding.RecommendationItemBinding
import com.example.myapplication.presentation.ui.profile.FirstprofileOptions
import com.example.myapplication.presentation.ui.profile.SecondprofileOptions

class ProfileSecondViewHolder (view: View): RecyclerView.ViewHolder(view){

    val binding = ListaPerfilBinding.bind(view)


    fun render(SecondprofileOptionsModel : SecondprofileOptions){
        binding.textView2.text = SecondprofileOptionsModel.boldtitle
        binding.textView3.text = SecondprofileOptionsModel.titles

    }
}