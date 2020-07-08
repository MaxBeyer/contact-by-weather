package com.max.contactbyweather.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Day(
    val clouds: Clouds?,
    val dt: Int?,
    val dt_txt: String?,
    val main: Main?,
    val rain: Rain?,
    val sys: Sys?,
    val weather: List<Weather>?,
    val wind: Wind?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Clouds(
    val all: Int
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Main(
    val feels_like: Double?,
    val grnd_level: Int?,
    val humidity: Int?,
    val pressure: Int?,
    val sea_level: Int?,
    val temp: Double?,
    val temp_kf: Double?,
    val temp_max: Double?,
    val temp_min: Double?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rain(
    val `3h`: Double?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Sys(
    val pod: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Wind(
    val deg: Int?,
    val speed: Double?
)
