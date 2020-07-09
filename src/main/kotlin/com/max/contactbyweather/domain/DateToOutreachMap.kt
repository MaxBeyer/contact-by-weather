package com.max.contactbyweather.domain

import java.time.LocalDate

data class DateToOutreachMap(
    internal val dateToOutreachMethod: Map<LocalDate, OutreachMethod>?
)
