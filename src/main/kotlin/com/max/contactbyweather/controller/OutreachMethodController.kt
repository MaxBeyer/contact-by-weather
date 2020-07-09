package com.max.contactbyweather.controller

import com.max.contactbyweather.config.ServiceProperties
import com.max.contactbyweather.domain.DateToOutreachMap
import com.max.contactbyweather.service.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OutreachMethodController(
    private val service: ContactService,
    private val properties: ServiceProperties
) {

    @GetMapping("/outreach")
    fun getOutreachMethods(
        @RequestParam("city", required = false) city: String?
    ): ResponseEntity<DateToOutreachMap> {
        val outreachMethod = service.getContactMethod(city ?: properties.defaultCity)
        return ResponseEntity.ok(outreachMethod)
    }
}
