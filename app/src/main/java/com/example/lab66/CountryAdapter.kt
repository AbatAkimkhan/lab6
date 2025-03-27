package com.example.lab66

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val countryList: List<Country>,
    private val onClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagImageView: ImageView = view.findViewById(R.id.flagImageView)
        val countryNameTextView: TextView = view.findViewById(R.id.countryNameTextView)
        val populationTextView: TextView = view.findViewById(R.id.populationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.flagImageView.setImageResource(country.flagResId)
        holder.countryNameTextView.text = country.name
        holder.populationTextView.text = "Population: ${country.population}"

        // Анимация при нажатии
        holder.itemView.setOnClickListener {
            val scaleAnimation = ScaleAnimation(
                1f, 1.1f,  // Увеличение по X от 1 до 1.1
                1f, 1.1f,  // Увеличение по Y от 1 до 1.1
                Animation.RELATIVE_TO_SELF, 0.5f,  // Центр по X
                Animation.RELATIVE_TO_SELF, 0.5f   // Центр по Y
            ).apply {
                duration = 200 // Длительность 200 мс
                fillAfter = true // Оставить в увеличенном состоянии
                repeatMode = Animation.REVERSE // Вернуться обратно
                repeatCount = 1 // Однократное повторение
            }
            holder.itemView.startAnimation(scaleAnimation)
            onClick(country)
        }
    }

    override fun getItemCount() = countryList.size
}
