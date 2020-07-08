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
            "list": [
                {
                    "dt": 1594166400,
                    "main": {
                        "temp": 303.39,
                        "feels_like": 306.23,
                        "temp_min": 303.39,
                        "temp_max": 303.74,
                        "pressure": 1012,
                        "sea_level": 1011,
                        "grnd_level": 984,
                        "humidity": 55,
                        "temp_kf": -0.35
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
                        "all": 60
                    },
                    "wind": {
                        "speed": 1.34,
                        "deg": 138
                    },
                    "rain": {
                        "3h": 0.54
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-08 00:00:00"
                },
                {
                    "dt": 1594177200,
                    "main": {
                        "temp": 301.31,
                        "feels_like": 303.66,
                        "temp_min": 300.83,
                        "temp_max": 301.31,
                        "pressure": 1011,
                        "sea_level": 1011,
                        "grnd_level": 983,
                        "humidity": 62,
                        "temp_kf": 0.48
                    },
                    "weather": [
                        {
                            "id": 801,
                            "main": "Clouds",
                            "description": "few clouds",
                            "icon": "02n"
                        }
                    ],
                    "clouds": {
                        "all": 24
                    },
                    "wind": {
                        "speed": 2.04,
                        "deg": 148
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-08 03:00:00"
                },
                {
                    "dt": 1594188000,
                    "main": {
                        "temp": 299.19,
                        "feels_like": 300.68,
                        "temp_min": 298.93,
                        "temp_max": 299.19,
                        "pressure": 1012,
                        "sea_level": 1012,
                        "grnd_level": 984,
                        "humidity": 69,
                        "temp_kf": 0.26
                    },
                    "weather": [
                        {
                            "id": 801,
                            "main": "Clouds",
                            "description": "few clouds",
                            "icon": "02n"
                        }
                    ],
                    "clouds": {
                        "all": 11
                    },
                    "wind": {
                        "speed": 3.08,
                        "deg": 150
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-08 06:00:00"
                },
                {
                    "dt": 1594198800,
                    "main": {
                        "temp": 298,
                        "feels_like": 299.06,
                        "temp_min": 297.96,
                        "temp_max": 298,
                        "pressure": 1010,
                        "sea_level": 1010,
                        "grnd_level": 982,
                        "humidity": 74,
                        "temp_kf": 0.04
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
                        "all": 42
                    },
                    "wind": {
                        "speed": 3.69,
                        "deg": 167
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-08 09:00:00"
                },
                {
                    "dt": 1594209600,
                    "main": {
                        "temp": 297.96,
                        "feels_like": 298.22,
                        "temp_min": 297.96,
                        "temp_max": 297.96,
                        "pressure": 1009,
                        "sea_level": 1009,
                        "grnd_level": 981,
                        "humidity": 72,
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
                        "all": 44
                    },
                    "wind": {
                        "speed": 4.51,
                        "deg": 171
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-08 12:00:00"
                },
                {
                    "dt": 1594220400,
                    "main": {
                        "temp": 302.44,
                        "feels_like": 302.31,
                        "temp_min": 302.44,
                        "temp_max": 302.44,
                        "pressure": 1008,
                        "sea_level": 1008,
                        "grnd_level": 981,
                        "humidity": 58,
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
                        "all": 8
                    },
                    "wind": {
                        "speed": 5.57,
                        "deg": 196
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-08 15:00:00"
                },
                {
                    "dt": 1594231200,
                    "main": {
                        "temp": 306.33,
                        "feels_like": 305.26,
                        "temp_min": 306.33,
                        "temp_max": 306.33,
                        "pressure": 1008,
                        "sea_level": 1008,
                        "grnd_level": 981,
                        "humidity": 46,
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
                        "all": 46
                    },
                    "wind": {
                        "speed": 6.8,
                        "deg": 188
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-08 18:00:00"
                },
                {
                    "dt": 1594242000,
                    "main": {
                        "temp": 307.34,
                        "feels_like": 306.67,
                        "temp_min": 307.34,
                        "temp_max": 307.34,
                        "pressure": 1007,
                        "sea_level": 1007,
                        "grnd_level": 980,
                        "humidity": 45,
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
                        "all": 37
                    },
                    "wind": {
                        "speed": 6.6,
                        "deg": 198
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-08 21:00:00"
                },
                {
                    "dt": 1594252800,
                    "main": {
                        "temp": 304.94,
                        "feels_like": 305.88,
                        "temp_min": 304.94,
                        "temp_max": 304.94,
                        "pressure": 1006,
                        "sea_level": 1006,
                        "grnd_level": 979,
                        "humidity": 57,
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
                        "all": 62
                    },
                    "wind": {
                        "speed": 5.53,
                        "deg": 201
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-09 00:00:00"
                },
                {
                    "dt": 1594263600,
                    "main": {
                        "temp": 302.35,
                        "feels_like": 304.12,
                        "temp_min": 302.35,
                        "temp_max": 302.35,
                        "pressure": 1007,
                        "sea_level": 1007,
                        "grnd_level": 980,
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
                        "all": 6
                    },
                    "wind": {
                        "speed": 4.52,
                        "deg": 200
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-09 03:00:00"
                },
                {
                    "dt": 1594274400,
                    "main": {
                        "temp": 300.48,
                        "feels_like": 303.89,
                        "temp_min": 300.48,
                        "temp_max": 300.48,
                        "pressure": 1007,
                        "sea_level": 1007,
                        "grnd_level": 979,
                        "humidity": 74,
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
                        "all": 42
                    },
                    "wind": {
                        "speed": 2.06,
                        "deg": 212
                    },
                    "rain": {
                        "3h": 0.52
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-09 06:00:00"
                },
                {
                    "dt": 1594285200,
                    "main": {
                        "temp": 296.93,
                        "feels_like": 298.61,
                        "temp_min": 296.93,
                        "temp_max": 296.93,
                        "pressure": 1008,
                        "sea_level": 1008,
                        "grnd_level": 980,
                        "humidity": 80,
                        "temp_kf": 0
                    },
                    "weather": [
                        {
                            "id": 501,
                            "main": "Rain",
                            "description": "moderate rain",
                            "icon": "10n"
                        }
                    ],
                    "clouds": {
                        "all": 99
                    },
                    "wind": {
                        "speed": 2.96,
                        "deg": 346
                    },
                    "rain": {
                        "3h": 4.53
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-09 09:00:00"
                },
                {
                    "dt": 1594296000,
                    "main": {
                        "temp": 297.42,
                        "feels_like": 299.08,
                        "temp_min": 297.42,
                        "temp_max": 297.42,
                        "pressure": 1006,
                        "sea_level": 1006,
                        "grnd_level": 979,
                        "humidity": 79,
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
                        "all": 99
                    },
                    "wind": {
                        "speed": 3.18,
                        "deg": 120
                    },
                    "rain": {
                        "3h": 0.22
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-09 12:00:00"
                },
                {
                    "dt": 1594306800,
                    "main": {
                        "temp": 300.33,
                        "feels_like": 301.21,
                        "temp_min": 300.33,
                        "temp_max": 300.33,
                        "pressure": 1006,
                        "sea_level": 1006,
                        "grnd_level": 979,
                        "humidity": 65,
                        "temp_kf": 0
                    },
                    "weather": [
                        {
                            "id": 804,
                            "main": "Clouds",
                            "description": "overcast clouds",
                            "icon": "04d"
                        }
                    ],
                    "clouds": {
                        "all": 99
                    },
                    "wind": {
                        "speed": 4.04,
                        "deg": 185
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-09 15:00:00"
                },
                {
                    "dt": 1594317600,
                    "main": {
                        "temp": 303.62,
                        "feels_like": 303.82,
                        "temp_min": 303.62,
                        "temp_max": 303.62,
                        "pressure": 1007,
                        "sea_level": 1007,
                        "grnd_level": 980,
                        "humidity": 48,
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
                        "all": 81
                    },
                    "wind": {
                        "speed": 3.83,
                        "deg": 240
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-09 18:00:00"
                },
                {
                    "dt": 1594328400,
                    "main": {
                        "temp": 303.26,
                        "feels_like": 303.69,
                        "temp_min": 303.26,
                        "temp_max": 303.26,
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
                        "all": 3
                    },
                    "wind": {
                        "speed": 4.91,
                        "deg": 284
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-09 21:00:00"
                },
                {
                    "dt": 1594339200,
                    "main": {
                        "temp": 302.51,
                        "feels_like": 302.3,
                        "temp_min": 302.51,
                        "temp_max": 302.51,
                        "pressure": 1007,
                        "sea_level": 1007,
                        "grnd_level": 980,
                        "humidity": 53,
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
                        "all": 14
                    },
                    "wind": {
                        "speed": 4.77,
                        "deg": 307
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-10 00:00:00"
                },
                {
                    "dt": 1594350000,
                    "main": {
                        "temp": 298.25,
                        "feels_like": 296.25,
                        "temp_min": 298.25,
                        "temp_max": 298.25,
                        "pressure": 1009,
                        "sea_level": 1009,
                        "grnd_level": 981,
                        "humidity": 50,
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
                        "speed": 4.63,
                        "deg": 300
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-10 03:00:00"
                },
                {
                    "dt": 1594360800,
                    "main": {
                        "temp": 296.16,
                        "feels_like": 294.68,
                        "temp_min": 296.16,
                        "temp_max": 296.16,
                        "pressure": 1011,
                        "sea_level": 1011,
                        "grnd_level": 983,
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
                        "speed": 4.33,
                        "deg": 305
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-10 06:00:00"
                },
                {
                    "dt": 1594371600,
                    "main": {
                        "temp": 294.33,
                        "feels_like": 293.14,
                        "temp_min": 294.33,
                        "temp_max": 294.33,
                        "pressure": 1012,
                        "sea_level": 1012,
                        "grnd_level": 984,
                        "humidity": 63,
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
                        "speed": 3.44,
                        "deg": 303
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-10 09:00:00"
                },
                {
                    "dt": 1594382400,
                    "main": {
                        "temp": 293.96,
                        "feels_like": 292.99,
                        "temp_min": 293.96,
                        "temp_max": 293.96,
                        "pressure": 1013,
                        "sea_level": 1013,
                        "grnd_level": 985,
                        "humidity": 63,
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
                        "speed": 2.95,
                        "deg": 299
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-10 12:00:00"
                },
                {
                    "dt": 1594393200,
                    "main": {
                        "temp": 298.39,
                        "feels_like": 297.22,
                        "temp_min": 298.39,
                        "temp_max": 298.39,
                        "pressure": 1014,
                        "sea_level": 1014,
                        "grnd_level": 986,
                        "humidity": 52,
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
                        "speed": 3.81,
                        "deg": 294
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-10 15:00:00"
                },
                {
                    "dt": 1594404000,
                    "main": {
                        "temp": 301.41,
                        "feels_like": 299.91,
                        "temp_min": 301.41,
                        "temp_max": 301.41,
                        "pressure": 1014,
                        "sea_level": 1014,
                        "grnd_level": 986,
                        "humidity": 45,
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
                        "speed": 4.54,
                        "deg": 296
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-10 18:00:00"
                },
                {
                    "dt": 1594414800,
                    "main": {
                        "temp": 302.29,
                        "feels_like": 300.84,
                        "temp_min": 302.29,
                        "temp_max": 302.29,
                        "pressure": 1013,
                        "sea_level": 1013,
                        "grnd_level": 985,
                        "humidity": 45,
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
                        "speed": 4.89,
                        "deg": 297
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-10 21:00:00"
                },
                {
                    "dt": 1594425600,
                    "main": {
                        "temp": 300.89,
                        "feels_like": 300.03,
                        "temp_min": 300.89,
                        "temp_max": 300.89,
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
                            "icon": "01d"
                        }
                    ],
                    "clouds": {
                        "all": 0
                    },
                    "wind": {
                        "speed": 4.61,
                        "deg": 303
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-11 00:00:00"
                },
                {
                    "dt": 1594436400,
                    "main": {
                        "temp": 298.38,
                        "feels_like": 298.86,
                        "temp_min": 298.38,
                        "temp_max": 298.38,
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
                        "speed": 2.35,
                        "deg": 308
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-11 03:00:00"
                },
                {
                    "dt": 1594447200,
                    "main": {
                        "temp": 296.58,
                        "feels_like": 298.06,
                        "temp_min": 296.58,
                        "temp_max": 296.58,
                        "pressure": 1013,
                        "sea_level": 1013,
                        "grnd_level": 985,
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
                        "speed": 1.12,
                        "deg": 348
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-11 06:00:00"
                },
                {
                    "dt": 1594458000,
                    "main": {
                        "temp": 294.8,
                        "feels_like": 295.62,
                        "temp_min": 294.8,
                        "temp_max": 294.8,
                        "pressure": 1013,
                        "sea_level": 1013,
                        "grnd_level": 985,
                        "humidity": 70,
                        "temp_kf": 0
                    },
                    "weather": [
                        {
                            "id": 801,
                            "main": "Clouds",
                            "description": "few clouds",
                            "icon": "02n"
                        }
                    ],
                    "clouds": {
                        "all": 23
                    },
                    "wind": {
                        "speed": 1.63,
                        "deg": 358
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-11 09:00:00"
                },
                {
                    "dt": 1594468800,
                    "main": {
                        "temp": 295.38,
                        "feels_like": 296.92,
                        "temp_min": 295.38,
                        "temp_max": 295.38,
                        "pressure": 1013,
                        "sea_level": 1013,
                        "grnd_level": 985,
                        "humidity": 67,
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
                        "all": 61
                    },
                    "wind": {
                        "speed": 0.53,
                        "deg": 75
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-11 12:00:00"
                },
                {
                    "dt": 1594479600,
                    "main": {
                        "temp": 299.31,
                        "feels_like": 300.87,
                        "temp_min": 299.31,
                        "temp_max": 299.31,
                        "pressure": 1014,
                        "sea_level": 1014,
                        "grnd_level": 986,
                        "humidity": 53,
                        "temp_kf": 0
                    },
                    "weather": [
                        {
                            "id": 804,
                            "main": "Clouds",
                            "description": "overcast clouds",
                            "icon": "04d"
                        }
                    ],
                    "clouds": {
                        "all": 93
                    },
                    "wind": {
                        "speed": 0.51,
                        "deg": 275
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-11 15:00:00"
                },
                {
                    "dt": 1594490400,
                    "main": {
                        "temp": 301.83,
                        "feels_like": 301.32,
                        "temp_min": 301.83,
                        "temp_max": 301.83,
                        "pressure": 1013,
                        "sea_level": 1013,
                        "grnd_level": 985,
                        "humidity": 44,
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
                        "all": 94
                    },
                    "wind": {
                        "speed": 3.14,
                        "deg": 19
                    },
                    "rain": {
                        "3h": 0.35
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-11 18:00:00"
                },
                {
                    "dt": 1594501200,
                    "main": {
                        "temp": 301.8,
                        "feels_like": 301.34,
                        "temp_min": 301.8,
                        "temp_max": 301.8,
                        "pressure": 1012,
                        "sea_level": 1012,
                        "grnd_level": 984,
                        "humidity": 43,
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
                        "all": 87
                    },
                    "wind": {
                        "speed": 2.88,
                        "deg": 53
                    },
                    "rain": {
                        "3h": 0.24
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-11 21:00:00"
                },
                {
                    "dt": 1594512000,
                    "main": {
                        "temp": 300.78,
                        "feels_like": 300.17,
                        "temp_min": 300.78,
                        "temp_max": 300.78,
                        "pressure": 1012,
                        "sea_level": 1012,
                        "grnd_level": 984,
                        "humidity": 47,
                        "temp_kf": 0
                    },
                    "weather": [
                        {
                            "id": 804,
                            "main": "Clouds",
                            "description": "overcast clouds",
                            "icon": "04d"
                        }
                    ],
                    "clouds": {
                        "all": 87
                    },
                    "wind": {
                        "speed": 3.33,
                        "deg": 39
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-12 00:00:00"
                },
                {
                    "dt": 1594522800,
                    "main": {
                        "temp": 298.17,
                        "feels_like": 298.49,
                        "temp_min": 298.17,
                        "temp_max": 298.17,
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
                        "all": 5
                    },
                    "wind": {
                        "speed": 2.48,
                        "deg": 40
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-12 03:00:00"
                },
                {
                    "dt": 1594533600,
                    "main": {
                        "temp": 295.77,
                        "feels_like": 295.55,
                        "temp_min": 295.77,
                        "temp_max": 295.77,
                        "pressure": 1014,
                        "sea_level": 1014,
                        "grnd_level": 986,
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
                        "all": 3
                    },
                    "wind": {
                        "speed": 2.35,
                        "deg": 72
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-12 06:00:00"
                },
                {
                    "dt": 1594544400,
                    "main": {
                        "temp": 294.02,
                        "feels_like": 292.97,
                        "temp_min": 294.02,
                        "temp_max": 294.02,
                        "pressure": 1015,
                        "sea_level": 1015,
                        "grnd_level": 987,
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
                        "speed": 1.93,
                        "deg": 61
                    },
                    "sys": {
                        "pod": "n"
                    },
                    "dt_txt": "2020-07-12 09:00:00"
                },
                {
                    "dt": 1594555200,
                    "main": {
                        "temp": 293.8,
                        "feels_like": 292.59,
                        "temp_min": 293.8,
                        "temp_max": 293.8,
                        "pressure": 1016,
                        "sea_level": 1016,
                        "grnd_level": 987,
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
                        "speed": 1.51,
                        "deg": 76
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-12 12:00:00"
                },
                {
                    "dt": 1594566000,
                    "main": {
                        "temp": 298.83,
                        "feels_like": 297.55,
                        "temp_min": 298.83,
                        "temp_max": 298.83,
                        "pressure": 1016,
                        "sea_level": 1016,
                        "grnd_level": 988,
                        "humidity": 35,
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
                        "speed": 1.54,
                        "deg": 85
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-12 15:00:00"
                },
                {
                    "dt": 1594576800,
                    "main": {
                        "temp": 302.72,
                        "feels_like": 301.87,
                        "temp_min": 302.72,
                        "temp_max": 302.72,
                        "pressure": 1016,
                        "sea_level": 1016,
                        "grnd_level": 988,
                        "humidity": 32,
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
                        "speed": 1.73,
                        "deg": 65
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-12 18:00:00"
                },
                {
                    "dt": 1594587600,
                    "main": {
                        "temp": 303.11,
                        "feels_like": 302.77,
                        "temp_min": 303.11,
                        "temp_max": 303.11,
                        "pressure": 1014,
                        "sea_level": 1014,
                        "grnd_level": 987,
                        "humidity": 36,
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
                        "speed": 1.93,
                        "deg": 74
                    },
                    "sys": {
                        "pod": "d"
                    },
                    "dt_txt": "2020-07-12 21:00:00"
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
