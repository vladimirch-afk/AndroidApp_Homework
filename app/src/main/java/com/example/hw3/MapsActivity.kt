package com.example.hw3

import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener {

    private lateinit var mMap: GoogleMap
    private lateinit var locationManager : LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        var mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION), 1)
        }
        else {
            locationManager = getSystemService(LOCALE_SERVICE) as LocationManager
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this)
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        //val point = LatLng(40.0, 40.0)
        //mMap.addMarker(MarkerOptions().position(point).title("Selected point"))
        mMap.isBuildingsEnabled = true
        mMap.isIndoorEnabled = true
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(point))
        var minusButton = findViewById<CardView>(R.id.minusButton)
        minusButton.setOnClickListener {
            mMap.animateCamera( CameraUpdateFactory.zoomTo( mMap.minZoomLevel) )
        }
        var plusButton = findViewById<CardView>(R.id.plusButton)
        plusButton.setOnClickListener {
            mMap.animateCamera( CameraUpdateFactory.zoomTo( (mMap.minZoomLevel + mMap.maxZoomLevel) / 2) )
        }
        mMap.isMyLocationEnabled = true
    }

    private fun setTheme() {
        when (intent.getIntExtra("Theme_type", 0)) {
            0 -> {setTheme(R.style.Theme_PurpleTheme)}
            1 -> {setTheme(R.style.Theme_BlueTheme)}
            2 -> {setTheme(R.style.Theme_GreenTheme)}
            3 -> {setTheme(R.style.Theme_RedTheme)}
        }
        setContentView(R.layout.activity_list)
    }

    override fun onLocationChanged(location: Location) {
    }
}