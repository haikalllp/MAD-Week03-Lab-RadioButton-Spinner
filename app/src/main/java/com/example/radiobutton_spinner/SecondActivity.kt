package com.example.radiobutton_spinner

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Using intent extras
        val countryFromIntent = intent.getStringExtra("country_key") ?: "N/A"
        val genderFromIntent = intent.getStringExtra("gender_key") ?: "N/A"

        // Using bundle
        val countryFromBundle = intent.extras?.getString("bundle_country_key", "N/A") ?: "N/A"
        val genderFromBundle = intent.extras?.getString("bundle_gender_key", "N/A") ?: "N/A"

        // Using Parcelable
        val userFromParcelable = intent.getParcelableExtra<User>("user_key")

        // Using Singleton (Global Value Holder)
        val singletonCountry = DataHolder.country
        val singletonGender = DataHolder.gender

        val displayText = """
            From Intent Extra:
            Country = $countryFromIntent
            Gender = $genderFromIntent
            
            From Bundle:
            Country = $countryFromBundle
            Gender = $genderFromBundle
            
            From Parcelable:
            Country = ${userFromParcelable?.country}
            Gender = ${userFromParcelable?.gender}
            
            From Singleton:
            Country = $singletonCountry
            Gender = $singletonGender
        """.trimIndent()

        findViewById<TextView>(R.id.textViewResult).text = displayText
    }
}