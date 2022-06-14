package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.profile.FirstprofileOptions
import com.example.myapplication.presentation.ui.profile.adapter.ProfileFirstViewHolder

class perfilcustomadapter (private val FirstprofileList : List<FirstprofileOptions>): RecyclerView.Adapter<ProfileFirstViewHolder> (){


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProfileFirstViewHolder {
        val LayoutInflater = LayoutInflater.from(viewGroup.context)
        return ProfileFirstViewHolder(LayoutInflater.inflate(R.layout.recommendation_item,viewGroup,false))
    }

    override fun onBindViewHolder(viewHolder: ProfileFirstViewHolder, i: Int) {
        val item =FirstprofileList[i]
        viewHolder.render(item)

    }

    override fun getItemCount(): Int =FirstprofileList.size


}
