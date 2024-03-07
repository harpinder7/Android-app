package com.example.AndroidProject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val textViewWelcome = findViewById<TextView>(R.id.textViewWelcome)
        val buttonViewArtworks = findViewById<Button>(R.id.buttonViewArtworks)
        val buttonExhibitions = findViewById<Button>(R.id.buttonExhibitions)

        // Handle button clicks
        buttonViewArtworks.setOnClickListener {
            // Open ArtworksActivity or navigate to the appropriate screen
            startActivity(Intent(this, ArtworksActivity::class.java))
        }

        buttonExhibitions.setOnClickListener {
            // Open ExhibitionsActivity or navigate to the appropriate screen
            startActivity(Intent(this, ExhibitionsActivity::class.java))
        }

        // Add more button click handlers or UI element interactions as needed
    }
}