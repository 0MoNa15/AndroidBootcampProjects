package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class recyclebuscarcustomadapter: RecyclerView.Adapter<recyclebuscarcustomadapter.ViewHolder>() {

    val titles = arrayOf("Arrow","Yo soy Betty la fea","The queen of flow","Edge of tomorrow","Knight Fall" , "Men in black")

    val details = arrayOf("2008","1999","2020","2016","2017","2022")

    val actors = arrayOf("Stephen Amel","Jorge Enrique y Ana Orozco","Tamy Andrade y Charly Flow","Tom Cruise","Beto A Saber" , "Thor y Valkiria")

    val images = intArrayOf(
        R.drawable.arrow,
        R.drawable.bety,
        R.drawable.queen,
        R.drawable.edge,
        R.drawable.fall,
        R.drawable.mib
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.recyclebuscar,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.textViewtitulo.text =titles[i]
        viewHolder.textViewyear.text =details[i]
        viewHolder.textViewactors.text =actors[i]
        viewHolder.imagepeli.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imagepeli: ImageView
        var textViewtitulo: TextView
        var textViewactors: TextView
        var textViewyear: TextView

        init{
            imagepeli = itemView.findViewById(R.id.imagepeli)
            textViewtitulo = itemView.findViewById(R.id.textViewtitulo)
            textViewyear = itemView.findViewById(R.id.textViewyear)
            textViewactors = itemView.findViewById(R.id.textViewactors)
        }

    }



}