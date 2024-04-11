package com.test.AndroidProject

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

        private lateinit var nameTextView: TextView
        private lateinit var birthdayTextView: TextView
        private lateinit var phoneNumberTextView: TextView
        private lateinit var emailTextView: TextView
        private lateinit var passwordTextView: TextView
        private lateinit var editProfileButton: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_profile)

            // Initialize views
            nameTextView = findViewById(R.id.nameTextView)
            birthdayTextView = findViewById(R.id.birthdayTextView)
            phoneNumberTextView = findViewById(R.id.phoneNumberTextView)
            emailTextView = findViewById(R.id.emailTextView)
            passwordTextView = findViewById(R.id.passwordTextView)
//            editProfileButton = findViewById(R.id.editProfileButton)

            // Set dummy data
            nameTextView.text = "Manpreet Kaur"
            birthdayTextView.text = "Birthday: October 1, 2003"
            phoneNumberTextView.text = "Phone Number: +1234567890"
            emailTextView.text = "Email: man@gmail.com"
            passwordTextView.text = "Password: ****"

            // Set onClickListener for Edit Profile Button
            editProfileButton.setOnClickListener {
                // Add logic to navigate to EditProfileActivity or implement editing functionality
            }
        }

}