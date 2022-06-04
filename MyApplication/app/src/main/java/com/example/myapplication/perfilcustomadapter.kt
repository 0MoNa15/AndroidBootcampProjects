package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class perfilcustomadapter: RecyclerView.Adapter<perfilcustomadapter.perfViewHolder> (){

    val images = arrayOf("Calificar y obtener recomendaciones","Agregar a lista","Aun pendiente")

    val titles = arrayOf("Calificaciones","Listas","Pendding")

    val details = arrayOf("0","4","0")



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): perfViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.recommendation_item,viewGroup,false)
        return perfViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: perfViewHolder, i: Int) {
        viewHolder.textView4.text =images[i]
        viewHolder.textView5.text =titles[i]
        viewHolder.textView6.text =details[i]

    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class perfViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var textView4: TextView
        var textView5: TextView
        var textView6: TextView

        init{
            textView4 = itemView.findViewById(R.id.textView4)
            textView5 = itemView.findViewById(R.id.textView5)
            textView6 = itemView.findViewById(R.id.textView6)
        }

    }



}
