package com.nathan.jetweatherforecast.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nathan.jetweatherforecast.data.RequestState
import com.nathan.jetweatherforecast.model.WeatherForecast
import com.nathan.jetweatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {
    val data: MutableState<RequestState<WeatherForecast, Boolean, Exception>>
        = mutableStateOf(RequestState(null, null, null))

    suspend fun getWeather(city: String) : RequestState<WeatherForecast, Boolean, Exception> {
        repository.getWeather(city = city, request = data.value)
        return data.value
    }
}