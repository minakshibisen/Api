package com.example.api.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
                signup()
            }
        }

    }

    private fun signup() {
        val map = mutableMapOf(
            "phone" to "7694930451",
            "name" to "name",
        )
        RetrofitClient.getInstance().userSignUp(map).enqueue(object :Callback<SignUpModel>{
            override fun onResponse(call: Call<SignUpModel>, response: Response<SignUpModel>) {
                if (response.code()== 200) {
                    if (response.body()!=null){

                        if (response.isSuccessful){
                            startActivity(Intent(this@SignUpActivity,OtpVerificationActivity::class.java))


                        }else{
                            Log.d("SignUpSuccess", "Sign-up successful: ${response.message()}")
                        }
                    }else{
                        Log.e("SignUpError", "Response body is null")

                    }

                }else{
                    Log.e("SignUpError", "Sign-up failed with code: ${response.code()} and message: ${response.message()}")

                }
            }

            override fun onFailure(call: Call<SignUpModel>, throwable: Throwable) {

            }

        })
    }

}
