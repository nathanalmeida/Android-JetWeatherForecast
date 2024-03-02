package com.nathan.jetweatherforecast.network

import com.nathan.jetweatherforecast.model.WeatherForecast
import com.nathan.jetweatherforecast.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherAPI {
    @GET("data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") apiKey: String = Constants.API_KEY,
    ): WeatherForecast
}