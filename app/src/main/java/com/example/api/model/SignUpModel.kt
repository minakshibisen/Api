package com.example.api.model

data class SignUpModel(
    val `data`: Data,
    val msg: String,
    val result: Boolean
){
    data class Data(
        val phone: String,
    )
}
