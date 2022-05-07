package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.lab2.databinding.ActivityMapsBinding
import logic.Ubication

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val back = findViewById<Button>(R.id.button2)
        back.setOnClickListener{
            val intent = Intent(this,Principal::class.java)
            startActivity(intent)
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val valor= intent.getSerializableExtra("envio")
        if(valor == "volcanes"){

            val arenal = LatLng(10.463, -84.703)
            val irazu = LatLng(9.979, -83.852)
            val miravalles = LatLng(10.784, -85.153)
            val orosi = LatLng(10.980, -85.473)
            val rinconVieja = LatLng(10.830,-85.324)
            mMap.addMarker(MarkerOptions().position(arenal).title("Volcan Arenal"))
            mMap.addMarker(MarkerOptions().position(irazu).title("Volcan Irazú"))
            mMap.addMarker(MarkerOptions().position(miravalles).title("Volcan Miravalles"))
            mMap.addMarker(MarkerOptions().position(orosi).title("Volcan Orosí"))
            mMap.addMarker(MarkerOptions().position(rinconVieja).title("Volcan Rincon de la Vieja"))
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE)
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arenal,5f))
        }else{
            if(valor == "campus"){
                val campusLiberia = LatLng(	10.6169978772,-85.4518945859)
                val campusAlajuela = LatLng(10.0195,-84.197)
                val campusNicoya = LatLng(10.1345,-85.4468)
                val campusCentral = LatLng(9.9988,-84.1115)
                val campusBrunca = LatLng(9.3797,-83.6915)
                val campusSarapiqui = LatLng(10.3186,-83.9231)
                val campusBarreal = LatLng(9.9707,-84.129)
                mMap.addMarker(MarkerOptions().position(campusLiberia).title("Campus Liberia"))
                mMap.addMarker(MarkerOptions().position(campusAlajuela).title("Campus Interuniversitaria de Alajuela"))
                mMap.addMarker(MarkerOptions().position(campusNicoya).title("Campus Nicoya"))
                mMap.addMarker(MarkerOptions().position(campusCentral).title("Campus Central Omar Dengo"))
                mMap.addMarker(MarkerOptions().position(campusBrunca).title("Campus Region Brunca"))
                mMap.addMarker(MarkerOptions().position(campusSarapiqui).title("Campus Sarapiqui"))
                mMap.addMarker(MarkerOptions().position(campusBarreal).title("Campus Benjamín Núñez"))
                
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(campusLiberia,5f))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val valor= intent.getSerializableExtra("envio")
        if(valor == "volcanes"){
            Toast.makeText(this, "Volcanes de Costa Rica", Toast.LENGTH_LONG).show()
            Log.i("act2","onStart")
        }else{
            if(valor == "campus"){
                Toast.makeText(this, "Campus de la UNA", Toast.LENGTH_LONG).show()
                Log.i("act2","onStart")
            }
        }
    }
}