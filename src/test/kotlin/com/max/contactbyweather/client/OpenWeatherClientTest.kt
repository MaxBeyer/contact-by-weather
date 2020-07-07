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
    "list": [
        {
            "dt": 1594144800,
            "main": {
                "temp": 302.72,
                "feels_like": 305.06,
                "temp_min": 302.72,
                "temp_max": 305.29,
                "pressure": 1015,
                "sea_level": 1014,
                "grnd_level": 986,
                "humidity": 55,
                "temp_kf": -2.57
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 66
            },
            "wind": {
                "speed": 1.64,
                "deg": 79
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-07 18:00:00"
        },
        {
            "dt": 1594155600,
            "main": {
                "temp": 303.8,
                "feels_like": 305.11,
                "temp_min": 303.8,
                "temp_max": 304.77,
                "pressure": 1013,
                "sea_level": 1012,
                "grnd_level": 985,
                "humidity": 48,
                "temp_kf": -0.97
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "clouds": {
                "all": 39
            },
            "wind": {
                "speed": 2.34,
                "deg": 120
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-07 21:00:00"
        },
        {
            "dt": 1594166400,
            "main": {
                "temp": 304.05,
                "feels_like": 305.37,
                "temp_min": 304.05,
                "temp_max": 304.31,
                "pressure": 1011,
                "sea_level": 1011,
                "grnd_level": 984,
                "humidity": 46,
                "temp_kf": -0.26
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "clouds": {
                "all": 45
            },
            "wind": {
                "speed": 2.05,
                "deg": 145
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-08 00:00:00"
        },
        {
            "dt": 1594177200,
            "main": {
                "temp": 301.26,
                "feels_like": 302.68,
                "temp_min": 301.26,
                "temp_max": 301.27,
                "pressure": 1011,
                "sea_level": 1011,
                "grnd_level": 984,
                "humidity": 59,
                "temp_kf": -0.01
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 1
            },
            "wind": {
                "speed": 2.8,
                "deg": 153
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-08 03:00:00"
        },
        {
            "dt": 1594188000,
            "main": {
                "temp": 299.46,
                "feels_like": 301.46,
                "temp_min": 299.46,
                "temp_max": 299.46,
                "pressure": 1012,
                "sea_level": 1012,
                "grnd_level": 984,
                "humidity": 70,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.69,
                "deg": 155
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-08 06:00:00"
        },
        {
            "dt": 1594198800,
            "main": {
                "temp": 298.46,
                "feels_like": 300.07,
                "temp_min": 298.46,
                "temp_max": 298.46,
                "pressure": 1010,
                "sea_level": 1010,
                "grnd_level": 983,
                "humidity": 77,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 99
            },
            "wind": {
                "speed": 3.66,
                "deg": 170
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-08 09:00:00"
        },
        {
            "dt": 1594209600,
            "main": {
                "temp": 298.48,
                "feels_like": 298.7,
                "temp_min": 298.48,
                "temp_max": 298.48,
                "pressure": 1009,
                "sea_level": 1009,
                "grnd_level": 981,
                "humidity": 76,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 73
            },
            "wind": {
                "speed": 5.51,
                "deg": 176
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-08 12:00:00"
        },
        {
            "dt": 1594220400,
            "main": {
                "temp": 303.03,
                "feels_like": 302.58,
                "temp_min": 303.03,
                "temp_max": 303.03,
                "pressure": 1008,
                "sea_level": 1008,
                "grnd_level": 981,
                "humidity": 56,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "clouds": {
                "all": 26
            },
            "wind": {
                "speed": 6.02,
                "deg": 209
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-08 15:00:00"
        },
        {
            "dt": 1594231200,
            "main": {
                "temp": 306.18,
                "feels_like": 305.7,
                "temp_min": 306.18,
                "temp_max": 306.18,
                "pressure": 1008,
                "sea_level": 1008,
                "grnd_level": 981,
                "humidity": 48,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02d"
                }
            ],
            "clouds": {
                "all": 13
            },
            "wind": {
                "speed": 6.33,
                "deg": 203
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-08 18:00:00"
        },
        {
            "dt": 1594242000,
            "main": {
                "temp": 307.01,
                "feels_like": 307.12,
                "temp_min": 307.01,
                "temp_max": 307.01,
                "pressure": 1007,
                "sea_level": 1007,
                "grnd_level": 980,
                "humidity": 48,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 6.03,
                "deg": 204
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-08 21:00:00"
        },
        {
            "dt": 1594252800,
            "main": {
                "temp": 305.12,
                "feels_like": 306.3,
                "temp_min": 305.12,
                "temp_max": 305.12,
                "pressure": 1007,
                "sea_level": 1007,
                "grnd_level": 979,
                "humidity": 56,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 4
            },
            "wind": {
                "speed": 5.09,
                "deg": 208
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-09 00:00:00"
        },
        {
            "dt": 1594263600,
            "main": {
                "temp": 302.19,
                "feels_like": 303.55,
                "temp_min": 302.19,
                "temp_max": 302.19,
                "pressure": 1006,
                "sea_level": 1006,
                "grnd_level": 979,
                "humidity": 66,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 4.79,
                "deg": 186
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-09 03:00:00"
        },
        {
            "dt": 1594274400,
            "main": {
                "temp": 300.91,
                "feels_like": 301.97,
                "temp_min": 300.91,
                "temp_max": 300.91,
                "pressure": 1008,
                "sea_level": 1008,
                "grnd_level": 981,
                "humidity": 68,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10n"
                }
            ],
            "clouds": {
                "all": 29
            },
            "wind": {
                "speed": 4.68,
                "deg": 218
            },
            "rain": {
                "3h": 0.15
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-09 06:00:00"
        },
        {
            "dt": 1594285200,
            "main": {
                "temp": 299.41,
                "feels_like": 302.89,
                "temp_min": 299.41,
                "temp_max": 299.41,
                "pressure": 1007,
                "sea_level": 1007,
                "grnd_level": 979,
                "humidity": 72,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10n"
                }
            ],
            "clouds": {
                "all": 100
            },
            "wind": {
                "speed": 0.86,
                "deg": 180
            },
            "rain": {
                "3h": 2
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-09 09:00:00"
        },
        {
            "dt": 1594296000,
            "main": {
                "temp": 299.03,
                "feels_like": 300.25,
                "temp_min": 299.03,
                "temp_max": 299.03,
                "pressure": 1006,
                "sea_level": 1006,
                "grnd_level": 979,
                "humidity": 74,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": {
                "all": 98
            },
            "wind": {
                "speed": 4.15,
                "deg": 179
            },
            "rain": {
                "3h": 1.15
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-09 12:00:00"
        },
        {
            "dt": 1594306800,
            "main": {
                "temp": 301.93,
                "feels_like": 303.29,
                "temp_min": 301.93,
                "temp_max": 301.93,
                "pressure": 1006,
                "sea_level": 1006,
                "grnd_level": 979,
                "humidity": 60,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": {
                "all": 98
            },
            "wind": {
                "speed": 3.49,
                "deg": 230
            },
            "rain": {
                "3h": 0.52
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-09 15:00:00"
        },
        {
            "dt": 1594317600,
            "main": {
                "temp": 303.17,
                "feels_like": 302.2,
                "temp_min": 303.17,
                "temp_max": 303.17,
                "pressure": 1007,
                "sea_level": 1007,
                "grnd_level": 980,
                "humidity": 46,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": {
                "all": 78
            },
            "wind": {
                "speed": 4.85,
                "deg": 290
            },
            "rain": {
                "3h": 2.08
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-09 18:00:00"
        },
        {
            "dt": 1594328400,
            "main": {
                "temp": 304.43,
                "feels_like": 304.29,
                "temp_min": 304.43,
                "temp_max": 304.43,
                "pressure": 1007,
                "sea_level": 1007,
                "grnd_level": 979,
                "humidity": 47,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 4.56,
                "deg": 285
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-09 21:00:00"
        },
        {
            "dt": 1594339200,
            "main": {
                "temp": 302.73,
                "feels_like": 301.35,
                "temp_min": 302.73,
                "temp_max": 302.73,
                "pressure": 1008,
                "sea_level": 1008,
                "grnd_level": 980,
                "humidity": 49,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 5.8,
                "deg": 293
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-10 00:00:00"
        },
        {
            "dt": 1594350000,
            "main": {
                "temp": 298.18,
                "feels_like": 296.62,
                "temp_min": 298.18,
                "temp_max": 298.18,
                "pressure": 1009,
                "sea_level": 1009,
                "grnd_level": 982,
                "humidity": 53,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 4.42,
                "deg": 291
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-10 03:00:00"
        },
        {
            "dt": 1594360800,
            "main": {
                "temp": 296.96,
                "feels_like": 295.84,
                "temp_min": 296.96,
                "temp_max": 296.96,
                "pressure": 1011,
                "sea_level": 1011,
                "grnd_level": 983,
                "humidity": 54,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 3.38,
                "deg": 276
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-10 06:00:00"
        },
        {
            "dt": 1594371600,
            "main": {
                "temp": 295.35,
                "feels_like": 294.72,
                "temp_min": 295.35,
                "temp_max": 295.35,
                "pressure": 1011,
                "sea_level": 1011,
                "grnd_level": 983,
                "humidity": 62,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.98,
                "deg": 287
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-10 09:00:00"
        },
        {
            "dt": 1594382400,
            "main": {
                "temp": 294.23,
                "feels_like": 293.09,
                "temp_min": 294.23,
                "temp_max": 294.23,
                "pressure": 1012,
                "sea_level": 1012,
                "grnd_level": 984,
                "humidity": 61,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 3.08,
                "deg": 300
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-10 12:00:00"
        },
        {
            "dt": 1594393200,
            "main": {
                "temp": 297.56,
                "feels_like": 295.83,
                "temp_min": 297.56,
                "temp_max": 297.56,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 985,
                "humidity": 50,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 3.95,
                "deg": 306
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-10 15:00:00"
        },
        {
            "dt": 1594404000,
            "main": {
                "temp": 301.31,
                "feels_like": 299.84,
                "temp_min": 301.31,
                "temp_max": 301.31,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 986,
                "humidity": 41,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 3.73,
                "deg": 303
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-10 18:00:00"
        },
        {
            "dt": 1594414800,
            "main": {
                "temp": 302.55,
                "feels_like": 300.79,
                "temp_min": 302.55,
                "temp_max": 302.55,
                "pressure": 1012,
                "sea_level": 1012,
                "grnd_level": 985,
                "humidity": 40,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 4.51,
                "deg": 292
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-10 21:00:00"
        },
        {
            "dt": 1594425600,
            "main": {
                "temp": 301.33,
                "feels_like": 300.5,
                "temp_min": 301.33,
                "temp_max": 301.33,
                "pressure": 1012,
                "sea_level": 1012,
                "grnd_level": 985,
                "humidity": 49,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 4.27,
                "deg": 300
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-11 00:00:00"
        },
        {
            "dt": 1594436400,
            "main": {
                "temp": 298.64,
                "feels_like": 299.26,
                "temp_min": 298.64,
                "temp_max": 298.64,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 985,
                "humidity": 58,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.29,
                "deg": 306
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-11 03:00:00"
        },
        {
            "dt": 1594447200,
            "main": {
                "temp": 296.78,
                "feels_like": 297.47,
                "temp_min": 296.78,
                "temp_max": 296.78,
                "pressure": 1014,
                "sea_level": 1014,
                "grnd_level": 986,
                "humidity": 66,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.36,
                "deg": 311
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-11 06:00:00"
        },
        {
            "dt": 1594458000,
            "main": {
                "temp": 295.68,
                "feels_like": 297.14,
                "temp_min": 295.68,
                "temp_max": 295.68,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 985,
                "humidity": 70,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 49
            },
            "wind": {
                "speed": 1.18,
                "deg": 285
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-11 09:00:00"
        },
        {
            "dt": 1594468800,
            "main": {
                "temp": 295.41,
                "feels_like": 296.69,
                "temp_min": 295.41,
                "temp_max": 295.41,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 985,
                "humidity": 71,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 55
            },
            "wind": {
                "speed": 1.43,
                "deg": 313
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-11 12:00:00"
        },
        {
            "dt": 1594479600,
            "main": {
                "temp": 300.89,
                "feels_like": 302.84,
                "temp_min": 300.89,
                "temp_max": 300.89,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 986,
                "humidity": 49,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "clouds": {
                "all": 47
            },
            "wind": {
                "speed": 0.07,
                "deg": 193
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-11 15:00:00"
        },
        {
            "dt": 1594490400,
            "main": {
                "temp": 301.68,
                "feels_like": 302.47,
                "temp_min": 301.68,
                "temp_max": 301.68,
                "pressure": 1012,
                "sea_level": 1012,
                "grnd_level": 984,
                "humidity": 47,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": {
                "all": 62
            },
            "wind": {
                "speed": 1.77,
                "deg": 100
            },
            "rain": {
                "3h": 0.42
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-11 18:00:00"
        },
        {
            "dt": 1594501200,
            "main": {
                "temp": 302.4,
                "feels_like": 301.67,
                "temp_min": 302.4,
                "temp_max": 302.4,
                "pressure": 1010,
                "sea_level": 1010,
                "grnd_level": 983,
                "humidity": 45,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": {
                "all": 90
            },
            "wind": {
                "speed": 3.92,
                "deg": 77
            },
            "rain": {
                "3h": 1.45
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-11 21:00:00"
        },
        {
            "dt": 1594512000,
            "main": {
                "temp": 300.62,
                "feels_like": 299.38,
                "temp_min": 300.62,
                "temp_max": 300.62,
                "pressure": 1010,
                "sea_level": 1010,
                "grnd_level": 983,
                "humidity": 52,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "clouds": {
                "all": 50
            },
            "wind": {
                "speed": 5.01,
                "deg": 65
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-12 00:00:00"
        },
        {
            "dt": 1594522800,
            "main": {
                "temp": 296.85,
                "feels_like": 294.99,
                "temp_min": 296.85,
                "temp_max": 296.85,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 985,
                "humidity": 52,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 4.11,
                "deg": 66
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-12 03:00:00"
        },
        {
            "dt": 1594533600,
            "main": {
                "temp": 294.03,
                "feels_like": 292.81,
                "temp_min": 294.03,
                "temp_max": 294.03,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 985,
                "humidity": 60,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 3,
                "deg": 59
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-12 06:00:00"
        },
        {
            "dt": 1594544400,
            "main": {
                "temp": 292.21,
                "feels_like": 291.38,
                "temp_min": 292.21,
                "temp_max": 292.21,
                "pressure": 1013,
                "sea_level": 1013,
                "grnd_level": 985,
                "humidity": 67,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.42,
                "deg": 59
            },
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2020-07-12 09:00:00"
        },
        {
            "dt": 1594555200,
            "main": {
                "temp": 291.4,
                "feels_like": 290.71,
                "temp_min": 291.4,
                "temp_max": 291.4,
                "pressure": 1014,
                "sea_level": 1014,
                "grnd_level": 986,
                "humidity": 76,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.77,
                "deg": 72
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-12 12:00:00"
        },
        {
            "dt": 1594566000,
            "main": {
                "temp": 295.35,
                "feels_like": 295.2,
                "temp_min": 295.35,
                "temp_max": 295.35,
                "pressure": 1015,
                "sea_level": 1015,
                "grnd_level": 987,
                "humidity": 66,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02d"
                }
            ],
            "clouds": {
                "all": 12
            },
            "wind": {
                "speed": 2.8,
                "deg": 102
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2020-07-12 15:00:00"
        }
    ],
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
