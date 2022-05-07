package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import logic.Ubication

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val enviarVol = findViewById<Button>(R.id.btnVolcanes)
        val enviarCamp = findViewById<Button>(R.id.btnCampus)
        var vol = "volcanes"

        var data = "envio"
        var ubication = Ubication()

        enviarVol.setOnClickListener{
            val intent = Intent(this,MapsActivity::class.java)
            intent.putExtra(data,vol)
            startActivity(intent)
        }

        enviarCamp.setOnClickListener{
            val intent = Intent(this,MapsActivity::class.java)
            intent.putExtra(data,"campus")
            startActivity(intent)
        }



    }
}