package com.example.api.util

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.api.ui.LoginActivity


class Session(context: Context?) {

    private val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_NAME = "BRIDGE_LOGIC_SALES_V1"
        private const val KEY_MY_PIN = "my_pin"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_EMP_NAME = "emp_name"
        private const val KEY_USER_IMAGE = "user_image"
        private const val KEY_USER_MOBILE = "user_mobile"
        private const val KEY_USER_EMAIL = "user_email"
        private const val KEY_USER_GENDER = "user_gender"
        private const val KEY_LOGGED_IN = "logged_in"

        private var instance: Session? = null

        fun getInstance(context: Context): Session {
            return instance ?: synchronized(this) {
                instance ?: Session(context).also { instance = it }
            }
        }
    }

    fun login(
        userId: String,
        empName: String,
        branchId: String,
        userProfileImage: String,
        userMobile: String,
        userEmail: String,
        userName: String,
        gender: String,
    ) {
        sharedPreferences.edit().apply {
            putString(KEY_USER_ID, userId)
            putString(KEY_USER_NAME, userName)
            putString(KEY_USER_IMAGE, userProfileImage)
            putString(KEY_USER_MOBILE, userMobile)
            putString(KEY_USER_EMAIL, userEmail)
            putString(KEY_USER_GENDER, gender)
            putString(KEY_EMP_NAME, empName)
            apply()
        }
    }

    fun setUserId(
        userId: String,
    ) {
        sharedPreferences.edit().apply {
            putString(KEY_USER_ID, userId)
            apply()
        }
    }

    fun setUserEmail(
        email: String,
    ) {
        sharedPreferences.edit().apply {
            putString(KEY_USER_EMAIL, email)
            apply()
        }
    }

    fun setLogin(isLoggedIn: Boolean) {
        sharedPreferences.edit().apply {
            putBoolean(KEY_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun setMyPin(pin: String) {
        sharedPreferences.edit().apply {
            putString(KEY_MY_PIN, pin)
            apply()
        }
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_LOGGED_IN, false)
    }

    fun getUserId(): String? {
        return sharedPreferences.getString(KEY_USER_ID, "")
    }

    fun getUserGender(): String? {
        return sharedPreferences.getString(KEY_USER_GENDER, "")
    }

    fun getUserName(): String? {
        return sharedPreferences.getString(KEY_USER_NAME, "")
    }

    fun getUserImage(): String? {
        return sharedPreferences.getString(KEY_USER_IMAGE, "")
    }

    fun getUserMobile(): String? {
        return sharedPreferences.getString(KEY_USER_MOBILE, "")
    }

    fun getUserEmail(): String? {
        return sharedPreferences.getString(KEY_USER_EMAIL, "")
    }



    fun logout(context: Context) {
        context.startActivity(
            Intent(context, LoginActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }

}