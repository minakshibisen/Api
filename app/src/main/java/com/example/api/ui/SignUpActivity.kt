package com.example.api.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.api.MainActivity
import com.example.api.R
import com.example.api.databinding.ActivitySignUpBinding
import com.example.api.model.SignUpModel
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.popupDialog
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
                signup(phone )
            }
        }



    }
    private fun signup(phone: String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["phone"] = phone

        RetrofitClient.getInstance().userSignUp(
            map
        ).enqueue(object : Callback<SignUpModel> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(
                call: Call<SignUpModel>,
                response: Response<SignUpModel>,
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.result) {
                            val data = response.body()!!.data


                            startActivity(
                                Intent(
                                    this@SignUpActivity, MainActivity::class.java
                                )
                            )

                        } else {
                            Toast.makeText(
                                this@SignUpActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                            ).show()
                        }


                    } else Toast.makeText(
                        this@SignUpActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                    ).show()
                } else Toast.makeText(
                    this@SignUpActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<SignUpModel>, t: Throwable) {
                popupDialog(
                    applicationContext,
                    "Request to server failed! Please try again after some time. ${t.cause}",
                    "Request Failed!",
                    "Ok",
                    true
                )
            }
        })
    }
}
