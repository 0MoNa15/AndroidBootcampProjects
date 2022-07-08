package com.example.alejobootcampandroid.presentation.ui.signup

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    val db = FirebaseFirestore.getInstance()

    private var _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean>
        get() = _status

    private var _messages = MutableLiveData<HashMap<String,String>>()
    val messages: LiveData<HashMap<String,String>>
        get() = _messages

    fun signUp(userName: String, email: String, userPassword: String) {
        //Toast.makeText(contex, "Search view Model", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, userPassword)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        saveInFirestore(userName, email)
                        _status.value = true
                        messages.value!!.put("title","exito")
                        messages.value!!.put("message","ok")
                    }else{
                        _status.value = false
                    }
                }
        }
    }

    private fun saveInFirestore(userName: String, userEmail: String) {
        db.collection("users").document(userEmail).set(
            hashMapOf("name" to userName, "email" to userEmail)
        )
    }
}