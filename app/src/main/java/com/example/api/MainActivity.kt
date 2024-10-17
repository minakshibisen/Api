
package com.example.api

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.api.databinding.ActivityMainBinding
import com.example.api.fragment.HomeFragment
import com.example.api.fragment.PersonFragment
import com.example.api.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.internal.http2.Settings


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var bottomNavigationView:BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment= PersonFragment()
        val secondFragment= HomeFragment()
        val thirdFragment= SettingFragment()

        setCurrentFragment(firstFragment)

        bottomNavigationView?.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.person->setCurrentFragment(secondFragment)
                R.id.settings->setCurrentFragment(thirdFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}