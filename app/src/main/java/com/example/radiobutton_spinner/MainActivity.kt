package com.example.radiobutton_spinner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
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
        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etAddress = findViewById<EditText>(R.id.etAddress)

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

            // Get entered name, age, and address
            val name = etName.text.toString()
            val age = etAge.text.toString().toIntOrNull() ?: 0
            val address = etAddress.text.toString()

            // Log values for debugging
            Log.d("UserInput", "Name: $name")
            Log.d("UserInput", "Age: $age")
            Log.d("UserInput", "Address: $address")
            Log.d("UserInput", "Country: $selectedCountry")
            Log.d("UserInput", "Gender: $selectedGender")

            // Optionally, show Toast to user
            Toast.makeText(this, "Selected: $selectedCountry, $selectedGender", Toast.LENGTH_SHORT).show()

            // Create an Intent to start SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // Pass data using Intent Extras
            intent.putExtra("name_key", name)
            intent.putExtra("age_key", age)
            intent.putExtra("address_key", address)
            intent.putExtra("country_key", selectedCountry)
            intent.putExtra("gender_key", selectedGender)

            // Pass data using Bundle
            val bundle = Bundle()
            bundle.putString("bundle_name_key", name)
            bundle.putInt("bundle_age_key", age)
            bundle.putString("bundle_address_key", address)
            bundle.putString("bundle_country_key", selectedCountry)
            bundle.putString("bundle_gender_key", selectedGender)
            intent.putExtras(bundle)

            // Pass data using Parcelable
            val user = User(name, age, address, selectedCountry, selectedGender)
            intent.putExtra("user_key", user)

            // Pass data using Singleton
            DataHolder.name = name
            DataHolder.age = age
            DataHolder.address = address
            DataHolder.country = selectedCountry
            DataHolder.gender = selectedGender

            // Start SecondActivity
            startActivity(intent)
        }
    }
}