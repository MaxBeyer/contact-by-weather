package com.max.contactbyweather.domain

import java.time.LocalDateTime

data class DateToOutreachMap(
    internal val dateToOutreachMethod: Map<LocalDateTime, OutreachMethod>?
)
