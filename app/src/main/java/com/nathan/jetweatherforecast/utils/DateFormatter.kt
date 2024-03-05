package com.nathan.jetweatherforecast.utils

import java.text.SimpleDateFormat
import java.util.Date

fun formatDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("EEE, MMM d")
    val date = Date(timestamp)
    return sdf.format(date)
}

fun formatDateTime(timestamp: Long): String {
    val sdf = SimpleDateFormat("hh:mm:aa")
    val date = Date(timestamp)
    return sdf.format(date)
}
