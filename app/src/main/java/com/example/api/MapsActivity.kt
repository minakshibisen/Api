package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.adapter.MapAdapter

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.api.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerMap.adapter = MapAdapter()
        binding.recyclerMap.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Initialize the map
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Optionally, set up the map's initial camera position, markers, etc.
        val initialLocation = LatLng(-34.0, 151.0)  // Sydney, for example
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 10f))

        // Add markers, customize map settings, etc.
        mMap.addMarker(MarkerOptions().position(initialLocation).title("Marker in Sydney"))

    }
}