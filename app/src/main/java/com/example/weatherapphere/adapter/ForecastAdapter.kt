package com.example.weatherapphere.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapphere.R
import com.example.weatherapphere.databinding.ItemWeatherForecastBinding
import com.example.weatherapphere.models.Forecast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ForecastAdapter(private val forecastList: List<Forecast>, private val backgroundResId: Int) :
    RecyclerView.Adapter<ForecastAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val forecast = forecastList[position]
        holder.bind(forecast)
    }

    override fun getItemCount(): Int = forecastList.size

    inner class WeatherViewHolder(private val binding: ItemWeatherForecastBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: Forecast) {
            // Set background resource
            Log.d("Inside, CDE", "Setting background resource: $backgroundResId")
            binding.root.setBackgroundResource(backgroundResId)

            // Parse date and format time
            val dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(forecast.dt_txt)
            val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
            val formattedTime = timeFormat.format(dateTime ?: Date())

            // Bind data to views
            binding.time.text = formattedTime
            binding.temperature.text = String.format("%.1f°C", forecast.main.temp - 273.15) // Convert Kelvin to Celsius

            // Set the weather icon
            val iconResId = getIconResId(forecast.weather[0].icon)
            binding.weatherIcon.setImageResource(iconResId)
        }

        private fun getIconResId(icon: String): Int {
            return when (icon) {
                "01d", "01n", "02d", "02n", "10d", "10n" -> R.drawable.ic_clear_day
                "03d", "03n" -> R.drawable.ic_cloudy_weather
                "04d", "04n" -> R.drawable.ic_broken_clouds
                "09d", "09n" -> R.drawable.ic_shower_rain
                "11d", "11n" -> R.drawable.ic_storm_weather
                "13d", "13n" -> R.drawable.ic_snow_weather
                "50d", "50n" -> R.drawable.ic_rainy_weather
                else -> R.drawable.ic_unknown
            }
        }
    }
}



