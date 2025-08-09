package com.example.radiobutton_spinner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class User(val country: String,
                val gender: String): Parcelable