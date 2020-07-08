package com.max.contactbyweather.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OpenWeatherResponse(
    val city: City? = null,
    val cnt: Int? = null,
    val cod: String? = null,
    val list: List<Day>? = null,
    val message: Int? = null
)
