package com.example.radiobutton_spinner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// DetailFragment displays the selected country and gender, and shows the country flag
class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageViewFlag)
        val countryText = view.findViewById<TextView>(R.id.textViewCountry)
        val nameValueText = view.findViewById<TextView>(R.id.textViewNameValue)
        val ageValueText = view.findViewById<TextView>(R.id.textViewAgeValue)
        val addressValueText = view.findViewById<TextView>(R.id.textViewAddressValue)
        val genderText = view.findViewById<TextView>(R.id.textViewGenderValue)

        // Fetch data from DataHolder singleton
        val country = DataHolder.country
        val gender = DataHolder.gender
        val name = DataHolder.name
        val age = DataHolder.age
        val address = DataHolder.address

        // Set country and gender text
        countryText.text = country
        genderText.text = gender

        // Set flag image based on country
        val flags = when (country) {
            "Australia" -> R.drawable.australia
            "India" -> R.drawable.india
            "USA" -> R.drawable.usa
            "Canada" -> R.drawable.canada
            else -> R.drawable.ic_launcher_foreground
        }
        imageView.setImageResource(flags)

        // Set name, age, and address text
        nameValueText.text = name ?: "N/A"
        ageValueText.text = age?.toString() ?: "N/A"
        addressValueText.text = address ?: "N/A"

        return view
    }
}
