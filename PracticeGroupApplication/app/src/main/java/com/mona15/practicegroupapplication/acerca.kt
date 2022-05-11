package com.mona15.practicegroupapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class acerca : AppCompatActivity() {
    lateinit var boton:Button
    lateinit var tv1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acerca)

        boton=findViewById(R.id.button2)
        tv1=findViewById(R.id.textView)
        var msgs = intent.extras
        val dato = msgs?.getString("usuario")
        tv1.text = dato.toString()
        boton.setOnClickListener {
            finish()
        }
    }
}