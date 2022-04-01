package com.example.flightsapplication.utils

import android.annotation.SuppressLint
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity
import com.example.flightsapplication.domain.models.FlightTicket
import java.text.SimpleDateFormat
import java.util.*

fun FlightTicketEntity.toFlightTicket() =
    FlightTicket(
        departure = departure,
        destination = destination,
        departDate = departDate,
        returnDate = returnDate,
        numberPassportPassenger = numberPassportPassenger,
        namePassenger = namePassenger,
        typePassenger = typePassenger.toTypePassenger()
    )


fun FlightTicket.toFlightTicketEntity() =
    FlightTicketEntity(
        departure = departure,
        destination = destination,
        departDate = departDate,
        returnDate = returnDate,
        numberPassportPassenger = numberPassportPassenger,
        namePassenger = namePassenger,
        typePassenger = typePassenger.type
    )


@SuppressLint("SimpleDateFormat")
fun String.fromStringToDate(): Date {
    return SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).parse(this)
        ?: throw IllegalStateException("Wrong format input")
}

@SuppressLint("SimpleDateFormat")
fun Date.fromDateToString(): String {
    return SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(this)
}

fun String.toTypePassenger(): FlightTicket.TypePassenger {
    return FlightTicket.TypePassenger.valueOf(this.uppercase())
}