package com.example.radiobutton_spinner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// SecondActivity hosts the Summary and Detail fragments and manages navigation between them
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Retain fragments on configuration changes (handled by FragmentManager)
        supportFragmentManager.fragmentFactory = supportFragmentManager.fragmentFactory

        // Initialize buttons
        val btnSummary = findViewById<android.widget.Button>(R.id.btnSummary)
        val btnDetail = findViewById<android.widget.Button>(R.id.btnDetail)

        // Show the default fragment (DetailFragment) on the first creation only
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, DetailFragment())
                .commit()
        }

        // Switch to SummaryFragment if not already displayed, and add to back stack
        btnSummary.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if (currentFragment !is SummaryFragment) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SummaryFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

        // Switch to DetailFragment if not already displayed, and add to back stack
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