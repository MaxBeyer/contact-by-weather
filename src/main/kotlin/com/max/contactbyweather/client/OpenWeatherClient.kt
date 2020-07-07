package com.max.contactbyweather.client

import com.max.contactbyweather.config.ServiceProperties
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

class OpenWeatherClient(
    private val properties: ServiceProperties,
    private val restTemplate: RestTemplate
) {
    fun getForcast(city: String): String? {
        val response = restTemplate.getForEntity<String>(
                properties.openWeatherUrl,
                hashMapOf(
                        "city" to city,
                        "appId" to properties.appId
                )
        )
        return when (response.statusCode) {
            HttpStatus.OK -> response.body.toString()
            else -> null
        }
    }
}
