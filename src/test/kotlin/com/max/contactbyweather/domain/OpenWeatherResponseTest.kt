package com.max.contactbyweather.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldNotBeNull
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert

class OpenWeatherResponseTest {

    private val objectMapper = ObjectMapper().apply {
        this.registerKotlinModule()
    }
    private val jsonResponse = """
        {
	"cod": "200",
	"message": 0,
	"cnt": 40,
	"list": [{
		"dt": 1578409200,
		"main": {
			"temp": 284.92,
			"feels_like": 281.38,
			"temp_min": 283.58,
			"temp_max": 284.92,
			"pressure": 1020,
			"sea_level": 1020,
			"grnd_level": 1016,
			"humidity": 90,
			"temp_kf": 1.34
		},
		"weather": [{
			"id": 804,
			"main": "Clouds",
			"description": "overcast clouds",
			"icon": "04d"
		}],
		"clouds": {
			"all": 100
		},
		"wind": {
			"speed": 5.19,
			"deg": 211
		},
		"sys": {
			"pod": "d"
		},
		"dt_txt": "2020-01-07 15:00:00"
	}],
	"city": {
		"id": 2643743,
		"name": "London",
		"coord": {
			"lat": 51.5073,
			"lon": -0.1277
		},
		"country": "GB",
		"timezone": 0,
		"sunrise": 1578384285,
		"sunset": 1578413272
	}
}
    """.trimIndent()

    @Test
    fun `converts string to object`() {
        // When
        val response = objectMapper.readValue<OpenWeatherResponse>(jsonResponse)

        // Then
        response.shouldNotBeNull()
        response.shouldBeInstanceOf<OpenWeatherResponse>()

        // would typically make this it's own test case, but this response object is so large...
        // When Again
        val responseString = objectMapper.writeValueAsString(response)

        // Then Again
        JSONAssert.assertEquals(jsonResponse, responseString, false)
    }
}
