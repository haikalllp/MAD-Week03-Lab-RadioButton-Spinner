package com.example.radiobutton_spinner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Load Summary Fragment
        val summary = SummaryFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, summary)
            .commit()
    }
}