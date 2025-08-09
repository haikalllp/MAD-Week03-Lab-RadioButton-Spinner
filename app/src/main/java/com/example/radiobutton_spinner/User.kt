package com.example.radiobutton_spinner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// User is a Parcelable data class for passing user info (country and gender) between activities
@Parcelize
// Holds the selected country and gender
// Implements Parcelable for easy transfer via Intent
// Example: intent.putExtra("user_key", user)
data class User(val country: String,
                val gender: String): Parcelable