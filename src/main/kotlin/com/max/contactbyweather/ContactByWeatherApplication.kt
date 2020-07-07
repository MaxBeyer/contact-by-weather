package com.max.contactbyweather

import com.max.contactbyweather.config.ServiceProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties::class)
class ContactByWeatherApplication

fun main(args: Array<String>) {
    runApplication<ContactByWeatherApplication>(*args)
}
