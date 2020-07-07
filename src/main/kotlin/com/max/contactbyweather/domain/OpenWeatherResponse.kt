package com.max.contactbyweather.domain

data class OpenWeatherResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Day>,
    val message: Int
)
