package com.mona15.practicegroupapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val txtName = findViewById<TextView>(R.id.txtName)
        val bundle = intent.extras
        val name = bundle?.getString("name")
        txtName.text = name.toString()
    }
}