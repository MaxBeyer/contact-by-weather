package com.max.contactbyweather.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Weather(
    val description: String? = null,
    val icon: String? = null,
    val id: Int? = null,
    val main: String? = null
)
