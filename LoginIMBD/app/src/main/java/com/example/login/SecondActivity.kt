package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        startsecondpanel()


    }

fun startsecondpanel(){
    val nombreusurario=findViewById<TextView>(R.id.textEmployeename)
    val objectoIntent: Intent =intent
    var nombre = objectoIntent.getStringExtra("user")

    nombreusurario.text = nombre
}



}