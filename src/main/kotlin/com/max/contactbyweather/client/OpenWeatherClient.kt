package com.max.contactbyweather.client

import com.max.contactbyweather.config.ServiceProperties
import org.springframework.web.client.RestTemplate

class OpenWeatherClient(
    private val properties: ServiceProperties,
    private val restTemplate: RestTemplate
) {
    fun getForcast(city: String): String {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
