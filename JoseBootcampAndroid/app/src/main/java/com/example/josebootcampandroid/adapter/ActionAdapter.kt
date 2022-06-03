package com.example.josebootcampandroid.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.databinding.ItemRecommendationBinding
import com.example.josebootcampandroid.model.Actions


class ActionAdapter(val listActions:List<Actions>) : RecyclerView.Adapter<ActionAdapter.ActionViewHolders>() {
    inner class ActionViewHolders(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemRecommendationBinding.bind(view)
        fun render(item: Actions) {
            binding.tvTitle.text = item.nombre
            binding.tvName.text = item.observaciones
            binding.tvName2.text = item.valoracion
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolders {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActionViewHolders(layoutInflater.inflate(R.layout.item_recommendation,parent,false))
    }

    override fun onBindViewHolder(holder: ActionViewHolders, position: Int) {
        val item = listActions[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listActions.size
}