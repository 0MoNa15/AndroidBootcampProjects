package com.example.myapplication.presentation.ui.profile

class ProfileSecondProvider {
    companion object{
        val profilesecondList = listOf<SecondprofileOptions>(
            SecondprofileOptions("Vistas recientes","No has visitado ninguna página recientemente."),
            SecondprofileOptions("Personas favoritas","El Calvo"),
            SecondprofileOptions("Aun pendiente","Pending")

        )
    }
}