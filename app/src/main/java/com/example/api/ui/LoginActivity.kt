package com.example.api.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.api.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView ( binding.root)

        binding.login.setOnClickListener {
            if (binding.edtMobileNo.text.isNullOrEmpty()) {
                binding.edtMobileNo.error="enter mobile no"

            }else{

            }
        }
    }
}