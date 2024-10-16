package com.example.api.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.api.databinding.ActivityLoginBinding
import com.example.api.model.SignUpModel
import com.example.onlinegroceries.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class
LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            if (binding.edtMobileNo.text.isNullOrEmpty()) {
                binding.edtMobileNo.error = "enter mobile no"

            } else {
                login()
            }
        }
    }

    private fun login() {
        RetrofitClient.getInstance().userSignUp()
            .enqueue(object : Callback<SignUpModel> {
                override fun onResponse(call: Call<SignUpModel>, response: Response<SignUpModel>) {
                    if (response.code() == 200) {
                        if (response.body() != null){

                        }else{

                        }
                    } else {

                    }
                }

                override fun onFailure(call: Call<SignUpModel>, response: Throwable) {

                }

            })
    }


-}


