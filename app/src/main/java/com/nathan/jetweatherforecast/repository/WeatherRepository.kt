package com.nathan.jetweatherforecast.repository

import com.nathan.jetweatherforecast.data.RequestState
import com.nathan.jetweatherforecast.model.WeatherForecast
import com.nathan.jetweatherforecast.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherAPI) {
    suspend fun getWeather(city: String, units: String = "imperial")
        : RequestState<WeatherForecast, Boolean, Exception> {
        val request: RequestState<WeatherForecast, Boolean, Exception>
            = RequestState(null, true, null)
        try {
            request.data = api.getWeather(city, units)
        } catch (e: Exception) {
            request.exception = e
        } finally {
            request.loading = false
        }

        return request
    }
}