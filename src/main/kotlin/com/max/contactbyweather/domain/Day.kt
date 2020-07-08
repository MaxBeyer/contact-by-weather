package com.max.contactbyweather.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Day(
    val clouds: Clouds? = null,
    val dt: Int? = null,
    val dt_txt: String? = null,
    val main: Main? = null,
    val rain: Rain? = null,
    val sys: Sys? = null,
    val weather: List<Weather>? = mutableListOf(),
    val wind: Wind? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Clouds(
    val all: Int? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Main(
    val feels_like: Double? = null,
    val grnd_level: Int? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,
    val sea_level: Int? = null,
    val temp: Double? = null,
    val temp_kf: Double? = null,
    val temp_max: Double? = null,
    val temp_min: Double? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rain(
    val `3h`: Double? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Sys(
    val pod: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Wind(
    val deg: Int? = null,
    val speed: Double? = null
)
