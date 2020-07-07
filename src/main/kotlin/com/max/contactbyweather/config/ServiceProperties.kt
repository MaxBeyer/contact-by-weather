package com.max.contactbyweather.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "openweather")
class ServiceProperties {
    lateinit var openWeatherUrl: String
    lateinit var appId: String
}
