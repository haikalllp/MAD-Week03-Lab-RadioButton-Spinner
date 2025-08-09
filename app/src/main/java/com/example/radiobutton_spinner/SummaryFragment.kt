package com.example.radiobutton_spinner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * SummaryFragment displays all the ways data can be passed from MainActivity to SecondActivity.
 * It demonstrates reading data from Intent extras, Bundle, Parcelable, and Singleton.
 */
class SummaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_summary, container, false)
        val summary = view.findViewById<android.widget.TextView>(R.id.textViewSummary)

        // Fetch data from intent via requireActivity().intent
        val intent = requireActivity().intent

        // Using Intent Extras
        val countryFromIntent = intent.getStringExtra("country_key") ?: "N/A"
        val genderFromIntent = intent.getStringExtra("gender_key") ?: "N/A"

        // Using Bundle
        val countryFromBundle = intent.extras?.getString("bundle_country_key", "N/A") ?: "N/A"
        val genderFromBundle = intent.extras?.getString("bundle_gender_key", "N/A") ?: "N/A"

        // Using Parcelable
        val userFromParcelable = intent.getParcelableExtra<User>("user_key")

        // Using Singleton
        val singletonCountry = DataHolder.country
        val singletonGender = DataHolder.gender

        // Build a summary string showing all data sources
        val displaySummary = """
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

        // Display the summary in the TextView
        summary.text = displaySummary
        return view
    }
}