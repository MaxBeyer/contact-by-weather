package com.max.contactbyweather.service

import com.max.contactbyweather.client.OpenWeatherClient
import com.max.contactbyweather.domain.City
import com.max.contactbyweather.domain.DateToOutreachMap
import com.max.contactbyweather.domain.Main
import com.max.contactbyweather.domain.OpenWeatherResponse
import com.max.contactbyweather.domain.OutreachMethod
import com.max.contactbyweather.domain.ThreeHourWindow
import com.max.contactbyweather.domain.Weather
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class ContactServiceTest {

    // text message -> when it is sunny and warmer than 75 degrees Fahrenheit
    // email -> when it is between 55 and 75 degrees Fahrenheit
    // phone call -> when it is less than 55 degrees or when it is raining.

    private val client: OpenWeatherClient = mockk()
    private val service = ContactService(client)
    private val localDate = LocalDateTime.parse("2020-07-08 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).plusSeconds(-18000)

    @Test
    fun `contact by email`() {
        // Given
        val response = OpenWeatherResponse(
                list = listOf(ThreeHourWindow(
                        main = Main(temp = 60.00),
                        weather = listOf(Weather(id = 800)),
                        dt_txt = "2020-07-08 00:00:00"
                )),
                city = City(
                        timezone = -18000
                )
        )
        every { client.getForcast(any()) } returns response

        // When
        val result = service.getContactMethod(city = "testville")

        // Then
        result shouldBeEqualTo DateToOutreachMap(mapOf(localDate to OutreachMethod.EMAIL))
    }

    @Test
    fun `contact by text`() {
        // Given
        val response = OpenWeatherResponse(
                list = listOf(ThreeHourWindow(
                        main = Main(temp = 76.00),
                        weather = listOf(Weather(id = 800)),
                        dt_txt = "2020-07-08 00:00:00"
                )),
                city = City(
                        timezone = -18000
                )
        )
        every { client.getForcast(any()) } returns response

        // When
        val result = service.getContactMethod(city = "testville")

        // Then
        result shouldBeEqualTo DateToOutreachMap(mapOf(localDate to OutreachMethod.TEXT_MESSAGE))
    }

    @Test
    fun `contact by phone`() {
        // Given
        val response = OpenWeatherResponse(
                list = listOf(ThreeHourWindow(
                        main = Main(temp = 54.0),
                        weather = listOf(Weather(id = 300)),
                        dt_txt = "2020-07-08 00:00:00"
                )),
                city = City(
                        timezone = -18000
                )
        )
        every { client.getForcast(any()) } returns response

        // When
        val result = service.getContactMethod(city = "testville")

        // Then
        result shouldBeEqualTo DateToOutreachMap(mapOf(localDate to OutreachMethod.PHONE_CALL))
    }
}
