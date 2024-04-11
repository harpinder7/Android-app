/*package com.test.AndroidProject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*
import android.widget.TextView

class ArtworkDetailActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork_detail)

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance().reference.child("artworks")

        // Get artwork key from intent extras
        val artworkKey = intent.getStringExtra("artworkKey")

        if (artworkKey != null) {
            // Find TextViews by their IDs
            val textViewPaintingName = findViewById<TextView>(R.id.textViewPaintingName)
            val textViewArtistName = findViewById<TextView>(R.id.textViewArtistName)
            val textViewCategory = findViewById<TextView>(R.id.textViewCategory)
            val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

            // Fetch artwork details from Firebase
            database.child(artworkKey).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val title = snapshot.child("title").value.toString()
                        val artist = snapshot.child("artist").value.toString()
                        val category = snapshot.child("category").value.toString()
                        val description = snapshot.child("description").value.toString()

                        // Update UI with artwork details
                        textViewPaintingName.text = title
                        textViewArtistName.text = artist
                        textViewCategory.text = category
                        textViewDescription.text = description
                    } else {
                        // Handle case when artwork with provided key does not exist
                        // For example, show an error message or navigate back to the previous activity
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error
                }
            })
        } else {
            // Handle case when artworkKey is null
            // For example, show an error message or navigate back to the previous activity
        }

        // Set up bottom navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle click on Home icon
                    navigateToHome()
                    true
                }
                R.id.navigation_details -> {
                    // Handle click on Dashboard icon
                    navigateToDashboard()
                    true
                }
                R.id.navigation_profile -> {
                    // Handle click on Notifications icon
                    navigateToProfile()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToHome() {
        // Start the HomeActivity
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToDashboard() {
        // Start the DashboardActivity
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToProfile() {
        // Start the ProfileActivity
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}*/
package com.test.AndroidProject

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*

class ArtworkDetailActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork_detail)

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance().reference.child("artworks")

        // Get artwork key from intent extras
        val artworkKey = intent.getStringExtra("artworkKey")

        if (artworkKey != null) {
            // Find TextViews by their IDs
            val textViewTitle = findViewById<TextView>(R.id.textViewPaintingName)
            val textViewArtist = findViewById<TextView>(R.id.textViewArtistName)
            val textViewCategory = findViewById<TextView>(R.id.textViewCategory)
            val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

            // Fetch artwork details from Firebase
            database.child(artworkKey).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val title = snapshot.child("title").getValue(String::class.java)
                        val artist = snapshot.child("artist").getValue(String::class.java)
                        val category = snapshot.child("category").getValue(String::class.java)
                        val description = snapshot.child("description").getValue(String::class.java)

                        // Update UI with artwork details
                        textViewTitle.text = title
                        textViewArtist.text = artist
                        textViewCategory.text = category
                        textViewDescription.text = description
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error
                }
            })
        }

        // Set up bottom navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle click on Home icon
                    navigateToHome()
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

    private fun navigateToHome() {
        // Start the HomeActivity
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToProfile() {
        // Start the ProfileActivity
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}

