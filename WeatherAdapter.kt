package com.example.task5_

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter(private val forecastDays: List<Forecastday>) :
  RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val dateTextView: TextView = itemView.findViewById(R.id.date_textview)
    val temperatureValueTextView: TextView =
      itemView.findViewById(R.id.temperature_value_textview)
    val humidityValueTextView: TextView = itemView.findViewById(R.id.humidity_value_textview)
    val precipitationValueTextView: TextView =
      itemView.findViewById(R.id.precipitation_value_textview)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.recyclerview_item_layout, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val forecastday = forecastDays[position].day
    holder.dateTextView.text = forecastDays[position].date
    holder.temperatureValueTextView.text = "${forecastday.avgtemp_c} °C"
    holder.humidityValueTextView.text = "${forecastday.avghumidity}%"
    holder.precipitationValueTextView.text = "${forecastday.totalprecip_mm} mm"
  }

  override fun getItemCount(): Int = forecastDays.size
}

