package com.example.myapplication.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)

        // Retrieve data passed from MainActivity
        val itemName = intent.getStringExtra("itemName")

        // Bind data to views
        val textViewName: TextView = findViewById(R.id.tvLifespanLabel)
        textViewName.text = itemName
    }
}
