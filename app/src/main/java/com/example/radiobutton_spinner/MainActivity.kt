package com.example.radiobutton_spinner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// MainActivity allows the user to select a country and gender, then submit the data
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI components
        val spinner = findViewById<Spinner>(R.id.spinnerCountry)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // Setup Spinner with sample data
        val countries = listOf("Australia", "India", "USA", "Canada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Handle submit button click
        btnSubmit.setOnClickListener {
            // Get selected country
            val selectedCountry = spinner.selectedItem.toString()

            // Get selected gender
            val selectedGenderId = radioGroup.checkedRadioButtonId
            val selectedGender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Not selected"
            }

            // Log values for debugging
            Log.d("UserInput", "Country: $selectedCountry")
            Log.d("UserInput", "Gender: $selectedGender")

            // Optionally, show Toast to user
            Toast.makeText(this, "Selected: $selectedCountry, $selectedGender", Toast.LENGTH_SHORT).show()

            // Create an Intent to start SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // Pass data using Intent Extras
            intent.putExtra("country_key", selectedCountry)
            intent.putExtra("gender_key", selectedGender)

            // Pass data using Bundle
            val bundle = Bundle()
            bundle.putString("bundle_country_key", selectedCountry)
            bundle.putString("bundle_gender_key", selectedGender)
            intent.putExtras(bundle)

            // Pass data using Parcelable
            val user = User(selectedCountry, selectedGender)
            intent.putExtra("user_key", user)

            // Pass data using Singleton
            DataHolder.country = selectedCountry
            DataHolder.gender = selectedGender

            // Start SecondActivity
            startActivity(intent)
        }
    }
}