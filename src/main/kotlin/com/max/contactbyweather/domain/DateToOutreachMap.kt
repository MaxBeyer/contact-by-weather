package com.max.contactbyweather.domain

import java.time.LocalDate

data class DateToOutreachMap(
    val dateToOutreachMethod: Map<LocalDate, OutreachMethod>?
)
