package com.example.api.remote

import com.example.api.model.SignUpModel
import com.example.api.util.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.signUp)
    fun userSignUp(@Body body: MutableMap<String, String>): Call<SignUpModel>

}