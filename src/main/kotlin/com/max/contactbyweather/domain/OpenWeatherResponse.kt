package com.max.contactbyweather.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OpenWeatherResponse(
    val city: City?,
    val cnt: Int?,
    val cod: String?,
    val list: List<Day>?,
    val message: Int?
)
