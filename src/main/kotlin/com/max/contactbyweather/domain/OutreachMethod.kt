package com.max.contactbyweather.domain

enum class OutreachMethod(val nameString: String) {
    EMAIL("email"),
    TEXT_MESSAGE("text message"),
    PHONE_CALL("phone call"),
    UNKNOWN("unknown")
}
