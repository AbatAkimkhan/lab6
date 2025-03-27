package com.example.lab66

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var selectedCountryTextView: TextView  // Изменил название переменной

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        selectedCountryTextView = findViewById(R.id.selectedCountryTextView) // Использую правильный ID

        recyclerView.layoutManager = LinearLayoutManager(this)

        val countryList = mutableListOf(
            Country("Kazakhstan", 19000000, R.drawable.kazakhstan_flag),
            Country("United States", 331000000, R.drawable.usa_flag),
            Country("Germany", 83000000, R.drawable.germany_flag)
        )

        countryAdapter = CountryAdapter(countryList) { country ->
            selectedCountryTextView.text = "Selected: ${country.name} (Population: ${country.population})"
        }

        recyclerView.adapter = countryAdapter
    }
}
// пустая строка
