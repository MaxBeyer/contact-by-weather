package com.max.contactbyweather.service

import com.max.contactbyweather.client.OpenWeatherClient
import com.max.contactbyweather.domain.DateContactMap

class ContactService(
    private val client: OpenWeatherClient
) {
    fun getContactMethod(city: String): DateContactMap {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
