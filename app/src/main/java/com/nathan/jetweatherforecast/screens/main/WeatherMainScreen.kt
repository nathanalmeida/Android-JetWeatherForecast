package com.nathan.jetweatherforecast.screens.main

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nathan.jetweatherforecast.data.RequestState
import com.nathan.jetweatherforecast.model.WeatherForecast

@Composable
fun WeatherMainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    ShowData(viewModel)
}

@Composable
fun ShowData(viewModel: MainViewModel) {
    val weatherData = produceState(
        initialValue = viewModel.data.value) {
        value = viewModel.getWeather("Seattle")
    }.value

    if(weatherData.loading == true) {
        CircularProgressIndicator()
    } else if(weatherData.data != null) {
        Text(text = "Main Screen ${weatherData.data}")
    }


}