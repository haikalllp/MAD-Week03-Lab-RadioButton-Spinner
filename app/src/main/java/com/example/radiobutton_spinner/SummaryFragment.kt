package com.example.radiobutton_spinner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [SummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SummaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        summary.text = displaySummary
        return view
    }
}