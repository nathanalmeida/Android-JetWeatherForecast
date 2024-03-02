package com.nathan.jetweatherforecast.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nathan.jetweatherforecast.data.RequestState
import com.nathan.jetweatherforecast.model.WeatherForecast
import com.nathan.jetweatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {
    private val _data: MutableStateFlow<RequestState<WeatherForecast, Boolean, Exception>>
        = MutableStateFlow(RequestState(null, null, null))
    val data = _data.asStateFlow()

    init {
        viewModelScope.launch {
            getWeather("Seattle")
        }
    }

    suspend fun getWeather(city: String) {
        _data.value.loading = true
        _data.value = repository.getWeather(city = city)
    }
}