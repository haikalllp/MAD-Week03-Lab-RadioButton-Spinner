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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinnerCountry)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // Setup Spinner with sample data
        val countries = listOf("Australia", "India", "USA", "Canada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

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

            // Log values
            Log.d("UserInput", "Country: $selectedCountry")
            Log.d("UserInput", "Gender: $selectedGender")

            // Optionally, show Toast
            Toast.makeText(this, "Selected: $selectedCountry, $selectedGender", Toast.LENGTH_SHORT).show()

            // Create an Intent to start SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // Using Intent Extras
            intent.putExtra("country_key", selectedCountry)
            intent.putExtra("gender_key", selectedGender)

            // Using Bundle
            val bundle = Bundle()
            bundle.putString("bundle_country_key", selectedCountry)
            bundle.putString("bundle_gender_key", selectedGender)
            intent.putExtras(bundle)

            // Using Parcelable
            val user = User(selectedCountry, selectedGender)
            intent.putExtra("user_key", user)

            // Using Singleton
            DataHolder.country = selectedCountry
            DataHolder.gender = selectedGender

            startActivity(intent)
        }
    }
}