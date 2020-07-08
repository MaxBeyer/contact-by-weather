package com.max.contactbyweather.service

import com.max.contactbyweather.client.OpenWeatherClient
import com.max.contactbyweather.domain.DateContactMap
import com.max.contactbyweather.domain.Day
import com.max.contactbyweather.domain.Main
import com.max.contactbyweather.domain.OpenWeatherResponse
import com.max.contactbyweather.domain.Weather
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ContactServiceTest {

    // text message -> when it is sunny and warmer than 75 degrees Fahrenheit
    // email -> when it is between 55 and 75 degrees Fahrenheit
    // phone call -> when it is less than 55 degrees or when it is raining.

    private val client: OpenWeatherClient = mockk()
    private val service = ContactService(client)

    private val response = OpenWeatherResponse(
            list = listOf(Day(
                    main = Main(temp = 60.00),
                    weather = listOf(Weather(id = 800)),
                    dt_txt = "2020-07-08 00:00:00"
            ))
    )

    @Disabled("not implemented")
    @Test
    fun `contact by email`() {
        // Given
        every { client.getForcast(any()) } returns response

        // When
        val result = service.getContactMethod(city = "testville")

        // Then
        result shouldBeEqualTo DateContactMap(mapOf("2020-07-08" to "email"))
    }
}
