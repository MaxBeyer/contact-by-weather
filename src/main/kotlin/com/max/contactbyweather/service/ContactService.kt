package com.max.contactbyweather.service

import com.max.contactbyweather.client.OpenWeatherClient
import com.max.contactbyweather.domain.City
import com.max.contactbyweather.domain.DateToOutreachMap
import com.max.contactbyweather.domain.OutreachMethod
import com.max.contactbyweather.domain.ThreeHourWindow
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val client: OpenWeatherClient
) {

    // returns the best OutreachMethod for a threeHourWindow using the following criteria:
    // text message -> when it is sunny and warmer than 75 degrees Fahrenheit
    // email -> when it is between 55 and 75 degrees Fahrenheit
    // phone call -> when it is less than 55 degrees or when it is raining.
    private fun getContactMethodOfDay(threeHourWindow: ThreeHourWindow): OutreachMethod {
        val temp = threeHourWindow.main?.temp ?: return OutreachMethod.UNKNOWN
        val weatherId = threeHourWindow.weather?.get(0)?.id // weather.id 2xx, 3xx, and 5xx are all rain
        return if (temp > 55 && temp < 76) { OutreachMethod.EMAIL }
            else if (temp < 55 || weatherId in 200..599) { OutreachMethod.PHONE_CALL }
            else if (temp > 75 && weatherId == 800) { OutreachMethod.TEXT_MESSAGE }
            else { OutreachMethod.UNKNOWN }
    }

    // gets the LocalDate using the timezone offset provided from response
    private fun getDateOfCity(threeHourWindow: ThreeHourWindow, city: City?): LocalDateTime {
        return LocalDateTime.parse(threeHourWindow.dt_txt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                .plusSeconds(city?.timezone?.toLong() ?: 0L) // this is the timezone offset
    }

    // returns an object containing a map of LocalDateTime to the best OutreachMethod
    fun getContactMethod(city: String): DateToOutreachMap {
        val response = client.getForcast(city) ?: return DateToOutreachMap(mapOf()) // if no response, return empty object
        val dateAndOutreachMethod = response.list?.map { day ->
            getDateOfCity(day, response.city) to getContactMethodOfDay(day)
        }?.toMap() ?: return DateToOutreachMap(mapOf())
        return contactAtLunch(dateAndOutreachMethod)
    }

    // people usually take a break at lunch.  That would be a good time to contact them.
    private fun contactAtLunch(dateAndOutreachMethod: Map<LocalDateTime, OutreachMethod>): DateToOutreachMap {
        // the API gives time windows for 3 hour intervals
        // each day should have one time within the range of 11:00AM - 1:00pm, so filter them out of the map to find the lunch hour
        val dayToOutreachMethod = dateAndOutreachMethod.filterKeys {
                    it.hour in LocalDate.now().atTime(11, 0, 0).hour..LocalDate.now().atTime(13, 0, 0).hour }.map {
                    it.key.toLocalDate() to it.value }.toMap()
        return DateToOutreachMap(dayToOutreachMethod)
    }
}
