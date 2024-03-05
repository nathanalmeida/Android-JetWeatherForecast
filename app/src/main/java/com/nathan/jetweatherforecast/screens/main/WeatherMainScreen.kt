package com.nathan.jetweatherforecast.screens.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.nathan.jetweatherforecast.model.WeatherForecast
import com.nathan.jetweatherforecast.utils.formatDate
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
    val weatherToday = weatherForecast.list[0]
    val imageUrl = "https://openweathermap.org/img/wn/${weatherToday.weather[0].icon}.png"
    
    Column(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = formatDate(weatherToday.dt),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp)
        )

        Surface(modifier = Modifier
            .padding(4.dp)
            .size(200.dp),
            shape = CircleShape,
            color = Color(0xFFFFC400)
        ) {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                WeatherStateImage(imageUrl = imageUrl)
                Text(text = "${weatherToday.temp.day.toInt().toString()}º",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold)
                Text(text = weatherToday.weather[0].main,
                    fontStyle = FontStyle.Italic)
            }
        }
    }
}

@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(painter = rememberImagePainter(imageUrl),
        contentDescription = "Icon Image",
        modifier = Modifier.size(80.dp),
        )
}
