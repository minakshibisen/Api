package com.example.api.ui

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.api.MainActivity
import com.example.api.R
import com.example.api.databinding.ActivityOtpVerificationBinding
import kotlinx.coroutines.MainScope

class OtpVerificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityOtpVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edtOne.requestFocus()
        binding.edtTwo.isEnabled = false
        binding.edtThree.isEnabled = false
        binding.edtFour.isEnabled = false
        setTextWatcher(binding.edtOne,  binding.edtTwo)
        setTextWatcher( binding.edtTwo,   binding.edtThree)
        setTextWatcher(  binding.edtThree,  binding.edtFour)
        binding.verifyOtp.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))

        }


    }
    fun setTextWatcher(currentEditText: EditText,nextEditText: EditText){

      currentEditText.addTextChangedListener(object : TextWatcher {
          override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
          }

          override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
          }

          override fun afterTextChanged(editable: Editable?) {
              val s =""
              if (!s.isNullOrEmpty()){

                  currentEditText.setBackgroundColor(R.color.blue)
                  nextEditText.isEnabled=true
                  nextEditText.requestFocus()
           }else{
                  currentEditText.setBackgroundColor(R.color.edit_text_color)
                  nextEditText.isEnabled=false

              }
          }
      })
    }

}
