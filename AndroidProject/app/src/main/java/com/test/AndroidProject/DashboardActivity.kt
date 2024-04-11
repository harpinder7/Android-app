package com.test.AndroidProject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*
import android.widget.ImageView

class DashboardActivity : AppCompatActivity() {

    private lateinit var artworks: List<Artwork>
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance().reference.child("artworks")

        // Find ImageViews by their IDs
        val imageViewArtwork1 = findViewById<ImageView>(R.id.imageViewArtwork1)
        val imageViewArtwork2 = findViewById<ImageView>(R.id.imageViewArtwork2)
        val imageViewArtwork3 = findViewById<ImageView>(R.id.imageViewArtwork3)
        val imageViewArtwork4 = findViewById<ImageView>(R.id.imageViewArtwork4)
        val imageViewArtwork5 = findViewById<ImageView>(R.id.imageViewArtwork5)
        val imageViewArtwork6 = findViewById<ImageView>(R.id.imageViewArtwork6)
        val imageViewArtwork7 = findViewById<ImageView>(R.id.imageViewArtwork7)
        val imageViewArtwork8 = findViewById<ImageView>(R.id.imageViewArtwork8)

        // Set click listeners for each ImageView
        imageViewArtwork1.setOnClickListener {
            navigateToArtworkDetails("1")
        }
        imageViewArtwork2.setOnClickListener {
            navigateToArtworkDetails("2")
        }
        imageViewArtwork3.setOnClickListener {
            navigateToArtworkDetails("3")
        }
        imageViewArtwork4.setOnClickListener {
            navigateToArtworkDetails("4")
        }
        imageViewArtwork5.setOnClickListener {
            navigateToArtworkDetails("5")
        }
        imageViewArtwork6.setOnClickListener {
            navigateToArtworkDetails("6")
        }
        imageViewArtwork7.setOnClickListener {
            navigateToArtworkDetails("7")
        }
        imageViewArtwork8.setOnClickListener {
            navigateToArtworkDetails("8")
        }

        // Set up bottom navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_details -> {
                    // Handle click on Details icon
                    navigateToDetails()
                    true
                }
                R.id.navigation_profile -> {
                    // Handle click on Profile icon
                    navigateToProfile()
                    true
                }
                else -> false
            }
        }
    }


    private fun navigateToArtworkDetails(artworkKey: String) {
        // Start the ArtworkDetailActivity and pass the artworkKey as extra
        val intent = Intent(this, ArtworkDetailActivity::class.java)
        intent.putExtra("artworkKey", artworkKey)
        startActivity(intent)
    }

    private fun navigateToDetails() {
        // Start the DetailsActivity
        val intent = Intent(this, ArtworkDetailActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToProfile() {
        // Start the ProfileActivity
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}
