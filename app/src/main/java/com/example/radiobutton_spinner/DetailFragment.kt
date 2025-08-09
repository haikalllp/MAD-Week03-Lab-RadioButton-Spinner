package com.example.radiobutton_spinner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageViewFlag)
        val countryText = view.findViewById<TextView>(R.id.textViewCountry)
        val genderText = view.findViewById<TextView>(R.id.textViewGender)

        // Fetch data from DataHolder singleton
        val country = DataHolder.country
        val gender = DataHolder.gender

        countryText.text = country
        genderText.text = gender

        // Example: Set image based on country (placeholder logic)
        val flagRes = when (country) {
            "Australia" -> R.drawable.australia
            "India" -> R.drawable.india
            "USA" -> R.drawable.usa
            "Canada" -> R.drawable.canada
            else -> R.drawable.ic_launcher_foreground
        }
        imageView.setImageResource(flagRes)

        return view
    }
}

