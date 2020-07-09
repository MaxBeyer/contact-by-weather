package com.max.contactbyweather.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.max.contactbyweather.config.ServiceProperties
import com.max.contactbyweather.domain.OpenWeatherResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Component
class OpenWeatherClient(
    private val properties: ServiceProperties,
    private val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this::class.java)
    private val objectMapper = ObjectMapper().registerKotlinModule()

    fun getForcast(city: String): OpenWeatherResponse? {
        try {
            val response = restTemplate.getForEntity<String>(
                    properties.openWeatherUrl,
                    hashMapOf(
                            "city" to city,
                            "appId" to properties.appId,
                            "units" to properties.units
                    )
            ).also { log.debug("Response from OpenWeather API: $it") }
            return when (response.statusCode) {
                HttpStatus.OK -> objectMapper.readValue(response.body.toString())
                else -> null
            }
        } catch (ex: HttpStatusCodeException) {
            return if (ex.statusCode == HttpStatus.NOT_FOUND) {
                log.error("${ex.statusCode}: '$city' could not be found as a city", ex.message)
                null
            } else {
                log.error("An error occured while requesting OpenWeatherApi. status=${ex.statusCode} body=${ex.responseBodyAsString}", ex)
                null
            }
        }
    }
}
