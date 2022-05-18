package com.example.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Procesos ()


    }

    fun Procesos (){

        var username : EditText = findViewById(R.id.TextPersonName)
        var pass : EditText = findViewById(R.id.TextPassword)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {


        val usernamelogin = username.text.toString()
            val passwordlogin = pass.text.toString()


            if(!usernamelogin.isEmpty()  && !passwordlogin.isEmpty()  ){

                // var Nombre : String = username.text.toString()

                //Envio segundo activity
                val intent = Intent(this, SecondActivity ::class.java)
                intent.putExtra("user", usernamelogin)
                startActivity(intent)
            }
            else if(usernamelogin.isEmpty() && passwordlogin.isEmpty()){
                var alert = AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please enter a user name and a password")
                alert.show()

            }
            else if(usernamelogin.isEmpty()){
                var alert = AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please enter a user name")
                alert.show()

            }else if(passwordlogin.isEmpty()){
                var alert = AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please enter a password")
                alert.show()


            }
            }

        }

    }






