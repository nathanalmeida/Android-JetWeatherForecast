package com.nathan.jetweatherforecast.model

data class WeatherForecast(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherDay>,
    val message: Double
)