package com.max.contactbyweather.client

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.max.contactbyweather.config.ServiceProperties
import org.amshove.kluent.shouldNotBeNull
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.web.client.RestTemplate

class OpenWeatherClientTest {

    private val wiremock = WireMockServer(0)
    private val properties = ServiceProperties().apply {
        appId = "09110e603c1d5c272f94f64305c09436"
    }
    private val client = OpenWeatherClient(properties = properties, restTemplate = RestTemplate())
    private val city = "minneapolis"
    private val jsonResponse = """{
    "cod": "200",
    "message": 0,
    "cnt": 40,
    "list": [],
    "city": {
        "id": 5037649,
        "name": "Minneapolis",
        "coord": {
            "lat": 44.98,
            "lon": -93.2638
        },
        "country": "US",
        "population": 382578,
        "timezone": -18000,
        "sunrise": 1594118065,
        "sunset": 1594173679
    }
}""".trimIndent()

    @BeforeEach
    fun setup() {
        wiremock.start()
        properties.openWeatherUrl = "http://localhost:${wiremock.port()}/forecast?q={city}&appid={appId}&"
    }

    @AfterEach
    fun tearDown() {
        wiremock.stop()
    }

    @Disabled("not implemented")
    @Test
    fun `gets 5 day forecast`() {
        // Given
        wiremock.stubFor(get(anyUrl())
                .willReturn(aResponse().withBody(jsonResponse)))

        // When
        val response = client.getForcast(city = city)

        // Then
        response.shouldNotBeNull()
        wiremock.verify(getRequestedFor(urlPathEqualTo("/forecast"))
                .withQueryParam("q", equalTo("minneapolis"))
                .withQueryParam("appid", equalTo("09110e603c1d5c272f94f64305c09436&")))
    }
}
