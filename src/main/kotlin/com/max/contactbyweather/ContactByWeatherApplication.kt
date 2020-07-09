package com.max.contactbyweather

import com.max.contactbyweather.config.ServiceProperties
import com.max.contactbyweather.controller.OutreachMethodController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties::class)
class ContactByWeatherApplication : CommandLineRunner {

    @Autowired
    lateinit var properties: ServiceProperties

    @Autowired
    lateinit var controller: OutreachMethodController

    override fun run(vararg args: String?) {
        println("\nFetching the best outreach methods for individuals in Minneapolis over the lunch hour for the next 5 days... \n")
        println("Date       : Outreach Method")
        println("----------------------------")
        controller.getOutreachMethods(properties.defaultCity).body?.dateToOutreachMethod?.forEach {
            println("${it.key} : ${it.value.nameString}")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ContactByWeatherApplication>(*args)
}
