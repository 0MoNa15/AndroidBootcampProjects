package com.mona15.practicegroupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private var etName: EditText? = null
    private var etPassword: EditText? = null
    private var txtName: TextView? = null
    private var txtPassword: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etName = findViewById(R.id.editTextName)
        etPassword = findViewById(R.id.editTextPassword)
        txtName = findViewById(R.id.tvName)
        txtPassword = findViewById((R.id.tvPassword))

        etName?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                txtName?.text = s
            }
        })
        etPassword?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                txtPassword?.text = s
            }
        })
    }

    fun dataValidation(name: String, password: String): Int {
        val allowedInput = "^[a-zA-Z ]*$".toRegex()
        name
        if (name.isEmpty() && password.isEmpty()) {
            return 1 // 1 means both the name and password fields are empty
        } else if (name.isEmpty()) {
            return 2 // 2 means the name is empty
        } else if (password.isEmpty()) {
            return 3 // 3 means the password field is empty
        } else {
            return 4 // 4 means the user's input is ok
        }
    }

    fun submitData(view: View) {
        val name: String = findViewById<EditText>(R.id.editTextName).text.toString()
        val password: String = findViewById<EditText>(R.id.editTextPassword).text.toString()
        val validationOutput = dataValidation(name, password)
        val nextActivity = Intent(this,HomeActivity::class.java)
        val bundle = Bundle()
        bundle.putString("name",name)
        nextActivity.putExtras(bundle)
        when (validationOutput) {
            1 -> Toast.makeText(this, R.string.restriction1V1, Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, R.string.restriction2V1, Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(this, R.string.restriction3V1, Toast.LENGTH_SHORT).show()
            4 -> startActivity(nextActivity)
        }
    }
}