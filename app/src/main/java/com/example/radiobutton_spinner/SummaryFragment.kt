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
        val nameFromIntent = intent.getStringExtra("name_key") ?: "N/A"
        val ageFromIntent = intent.getIntExtra("age_key", -1)
        val addressFromIntent = intent.getStringExtra("address_key") ?: "N/A"

        // Using Bundle
        val countryFromBundle = intent.extras?.getString("bundle_country_key", "N/A") ?: "N/A"
        val genderFromBundle = intent.extras?.getString("bundle_gender_key", "N/A") ?: "N/A"
        val nameFromBundle = intent.extras?.getString("bundle_name_key", "N/A") ?: "N/A"
        val ageFromBundle = intent.extras?.getInt("bundle_age_key", -1) ?: -1
        val addressFromBundle = intent.extras?.getString("bundle_address_key", "N/A") ?: "N/A"

        // Using Parcelable
        val userFromParcelable = intent.getParcelableExtra<User>("user_key")

        // Using Singleton
        val singletonCountry = DataHolder.country ?: "N/A"
        val singletonGender = DataHolder.gender ?: "N/A"
        val singletonName = DataHolder.name ?: "N/A"
        val singletonAge = DataHolder.age ?: -1
        val singletonAddress = DataHolder.address ?: "N/A"

        // Build a summary string showing all data sources
        val displaySummary = """
            From Intent Extra:
            Name = $nameFromIntent
            Age = ${if (ageFromIntent == -1) "N/A" else ageFromIntent}
            Address = $addressFromIntent
            Country = $countryFromIntent
            Gender = $genderFromIntent
            
            From Bundle:
            Name = $nameFromBundle
            Age = ${if (ageFromBundle == -1) "N/A" else ageFromBundle}
            Address = $addressFromBundle
            Country = $countryFromBundle
            Gender = $genderFromBundle
            
            From Parcelable:
            Name = ${userFromParcelable?.name ?: "N/A"}
            Age = ${userFromParcelable?.age ?: "N/A"}
            Address = ${userFromParcelable?.address ?: "N/A"}
            Country = ${userFromParcelable?.country ?: "N/A"}
            Gender = ${userFromParcelable?.gender ?: "N/A"}
            
            From Singleton:
            Name = $singletonName
            Age = ${if (singletonAge == -1) "N/A" else singletonAge}
            Address = $singletonAddress
            Country = $singletonCountry
            Gender = $singletonGender
        """.trimIndent()

        // Display the summary in the TextView
        summary.text = displaySummary
        return view
    }
}