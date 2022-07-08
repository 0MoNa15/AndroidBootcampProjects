package com.example.alejobootcampandroid.presentation.ui.signup

import com.example.alejobootcampandroid.R

class UserDataValidation {

    companion object{
         fun isFieldEmpty(data: String): String? {
            var message: String? = null
            if (!data.isBlank()){
                message = "El campo es requrido"
            }
            return message
        }
    }


}