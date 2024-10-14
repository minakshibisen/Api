package com.example.api.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.api.MainActivity
import com.example.api.databinding.ActivitySignUpBinding
import com.example.api.model.SignUpModel
import com.example.onlinegroceries.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val phone: String? = intent.getStringExtra("phone")


        binding.signUp.setOnClickListener {
            if (binding.edtMobileNo.text.isNullOrEmpty() && binding.edtUserName.text.isNullOrEmpty()
            ) {
                binding.edtMobileNo.error = "Enter Mobile no"
                binding.edtUserName.error = "Enter User name"
                binding.edtUserName.requestFocus()
                binding.edtMobileNo.requestFocus()

            } else {
                signup(phone)
            }
        }

    }

    private fun signup() {

        RetrofitClient.getInstance().userSignUp().enqueue(object :Callback<SignUpModel>{
            override fun onResponse(call: Call<SignUpModel>, response: Response<SignUpModel>) {
                if (response.code()== 200) {
                    if (response.body()!=null){

                    }

                }
            }

            override fun onFailure(call: Call<SignUpModel>, throwable: Throwable) {

            }

        })
    }

}
