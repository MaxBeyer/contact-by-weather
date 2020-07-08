package com.max.contactbyweather.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Weather(
    val description: String?,
    val icon: String?,
    val id: Int?,
    val main: String?
)
