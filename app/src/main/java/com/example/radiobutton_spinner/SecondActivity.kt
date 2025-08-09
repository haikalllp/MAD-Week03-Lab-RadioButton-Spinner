package com.example.radiobutton_spinner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Retain fragments on configuration changes
        supportFragmentManager.fragmentFactory = supportFragmentManager.fragmentFactory

        // Initialize buttons
        val btnSummary = findViewById<android.widget.Button>(R.id.btnSummary)
        val btnDetail = findViewById<android.widget.Button>(R.id.btnDetail)

        // Show the default fragment on the first creation
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, DetailFragment())
                .commit()
        }

        // Switch to summary fragment on button click if not already displayed
        // When switching add to back stack to allow navigation back
        btnSummary.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if (currentFragment !is SummaryFragment) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SummaryFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

        // Switch to detail fragment on button click if not already displayed
        btnDetail.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if (currentFragment !is DetailFragment) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, DetailFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}