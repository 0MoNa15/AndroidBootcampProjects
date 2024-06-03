package com.mona15.practicegroupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var boton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        boton = findViewById(R.id.button)

        boton.setOnClickListener {

            if (et1.toString().length==0)
                Toast.makeText(this,"La c no debe estar vacia",Toast.LENGTH_LONG).show()
            if (et2.toString().length==0)
                Toast.makeText(this,"La clave no debe estar vacia",Toast.LENGTH_LONG).show()

            if (et1.text.toString().equals("Jose")&&et2.text.toString().equals("12345"))
            {
                val intento = Intent(this,acerca::class.java)
                intento.putExtra("usuario",et1.text.toString())
                startActivity(intento)
            }

        }

    }
}