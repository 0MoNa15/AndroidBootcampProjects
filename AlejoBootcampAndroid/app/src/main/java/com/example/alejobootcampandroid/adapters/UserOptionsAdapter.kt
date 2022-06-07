package com.example.alejobootcampandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.ItemRecommendationBinding
import com.example.alejobootcampandroid.model.UserOptions

class UserOptionsAdapter(val userOptionsList : List<UserOptions>): RecyclerView.Adapter<UserOptionsAdapter.UserOptionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserOptionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserOptionsViewHolder(layoutInflater.inflate(R.layout.item_recommendation,parent,false))
    }

    override fun onBindViewHolder(holder: UserOptionsViewHolder, position: Int) {
        val item = userOptionsList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = userOptionsList.size

    inner class UserOptionsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
       val binding = ItemRecommendationBinding.bind(itemView)

        fun render(userOptionsItem: UserOptions){
            binding.tvUserRateMovie.text = userOptionsItem.description
            binding.tvUserRatings.text = userOptionsItem.title
            binding.tvUserRatingsValue.text = "${userOptionsItem.value}"
        }
    }

}