package com.max.contactbyweather

import com.max.contactbyweather.config.ServiceProperties
import org.amshove.kluent.shouldNotBeNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ContactByWeatherApplicationTests {

    @Autowired
    lateinit var config: ServiceProperties

    @Test
    fun contextLoads() {
        config.shouldNotBeNull()
    }
}
