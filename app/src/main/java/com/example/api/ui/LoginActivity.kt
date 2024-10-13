package com.example.api.ui

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.api.R
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