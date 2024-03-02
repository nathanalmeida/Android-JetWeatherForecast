package com.nathan.jetweatherforecast.screens.main

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun WeatherMainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    ShowData(viewModel)
}

@Composable
fun ShowData(viewModel: MainViewModel) {
    val weatherData = viewModel.data.collectAsState().value

    if(weatherData.loading == true) {
        CircularProgressIndicator()
    } else if(weatherData.data != null) {
        Text(text = "Main Screen ${weatherData.data}")
    }


}