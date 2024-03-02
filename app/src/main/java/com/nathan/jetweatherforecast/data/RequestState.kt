package com.nathan.jetweatherforecast.data

class RequestState<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var exception: E? = null,
) {
}