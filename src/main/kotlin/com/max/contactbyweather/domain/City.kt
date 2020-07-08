package com.max.contactbyweather.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class City(
    val coord: Coord?,
    val country: String?,
    val id: Int?,
    val name: String?,
    val population: Int?,
    val sunrise: Int?,
    val sunset: Int?,
    val timezone: Int?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Coord(
    val lat: Double?,
    val lon: Double?
)
