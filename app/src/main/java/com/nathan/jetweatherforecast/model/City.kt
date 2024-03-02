package com.nathan.jetweatherforecast.model

data class City(
    val coordinate: Coordinate,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val timezone: Int
)