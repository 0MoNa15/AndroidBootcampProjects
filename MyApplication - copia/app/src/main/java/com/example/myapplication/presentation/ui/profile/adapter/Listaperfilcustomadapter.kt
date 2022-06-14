package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.profile.FirstprofileOptions
import com.example.myapplication.presentation.ui.profile.SecondprofileOptions
import com.example.myapplication.presentation.ui.profile.adapter.ProfileFirstViewHolder
import com.example.myapplication.presentation.ui.profile.adapter.ProfileSecondViewHolder

class listaperfilcustomadapter (private val SecondprofileList : List<SecondprofileOptions>): RecyclerView.Adapter<ProfileSecondViewHolder>(){

    /*val boldtitle = arrayOf("Vistas recientes","Personas favoritas","Aun pendiente")

    val titles = arrayOf("No has visitado ninguna página recientemente."," Esteban Osorio EL CALVO","Pending")

*/
override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProfileSecondViewHolder {
        val LayoutInflater = LayoutInflater.from(viewGroup.context)
        return ProfileSecondViewHolder(LayoutInflater.inflate(R.layout.lista_perfil,viewGroup,false))

    }

    override fun onBindViewHolder(viewHolder: ProfileSecondViewHolder, i: Int) {
        val item =SecondprofileList[i]
        viewHolder.render(item)
    }

    override fun getItemCount(): Int = SecondprofileList.size


}