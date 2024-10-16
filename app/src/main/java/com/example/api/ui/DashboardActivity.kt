package com.example.api.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.MapsActivity
import com.example.api.adapter.DashboardAdapter
import com.example.api.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    lateinit var binding:ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.locationMao.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))

        }

        binding.recyclerDashboard.adapter = DashboardAdapter(this)
        binding.recyclerDashboard.layoutManager=LinearLayoutManager(this)

    }
}

