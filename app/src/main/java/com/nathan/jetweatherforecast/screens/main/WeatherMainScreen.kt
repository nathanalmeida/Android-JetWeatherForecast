package com.nathan.jetweatherforecast.screens.main

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nathan.jetweatherforecast.model.WeatherForecast
import com.nathan.jetweatherforecast.widgets.WeatherTopBar

@Composable
fun WeatherMainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    val weatherData = viewModel.data.collectAsState().value

    if(weatherData.loading == true) {
        CircularProgressIndicator()
    } else if(weatherData.data != null) {
        MainScaffold(weatherForecast = weatherData.data!!, navController)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(weatherForecast: WeatherForecast, navController: NavController) {
    Scaffold(
        topBar = { WeatherTopBar(title = "${weatherForecast.city.name}, ${weatherForecast.city.country}",
            navController = navController,
            elevation = 5.dp
        ) {
            Log.d("TESTING", "MainScaffold: Button Clicked")
        }
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            MainContent(weatherForecast)
        }

    }


}

@Composable
fun MainContent(weatherForecast: WeatherForecast) {
    Text(text = weatherForecast.city.name)
}
