package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class listaperfilcustomadapter : RecyclerView.Adapter<listaperfilcustomadapter.perfViewHolder> (){

    val boldtitle = arrayOf("Vistas recientes","Personas favoritas","Aun pendiente")

    val titles = arrayOf("No has visitado ninguna página recientemente."," Esteban Osorio EL CALVO","Pending")


override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): perfViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.lista_perfil,viewGroup,false)
        return perfViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: perfViewHolder, i: Int) {
        viewHolder.textView2.text =boldtitle[i]
        viewHolder.textView3.text =titles[i]
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class perfViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textView2: TextView
        var textView3: TextView


        init{
            textView2 = itemView.findViewById(R.id.textView2)
            textView3 = itemView.findViewById(R.id.textView3)

        }

    }



}