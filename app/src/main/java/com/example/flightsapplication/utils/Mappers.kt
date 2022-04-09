package com.example.flightsapplication.utils

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.example.flightsapplication.R
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
        passengerAge = passengerAge.toPassengerAge(),
        id = id
    )


fun FlightTicket.toFlightTicketEntity() =
    FlightTicketEntity(
        departure = departure,
        destination = destination,
        departDate = departDate,
        returnDate = returnDate,
        numberPassportPassenger = numberPassportPassenger,
        namePassenger = namePassenger,
        passengerAge = passengerAge.idAge,
        id = id
    )

@SuppressLint("SimpleDateFormat")
fun String.fromStringToDate(): Date {
    return SimpleDateFormat(Constant.DATE_FORMAT, Locale.ENGLISH).parse(this)
        ?: throw IllegalStateException("Wrong format input")
}

@SuppressLint("SimpleDateFormat")
fun Date.fromDateToString(): String {
    return SimpleDateFormat(Constant.DATE_FORMAT, Locale.ENGLISH).format(this)
}

fun Int.toPassengerAge(): FlightTicket.PassengerAge {
    return when(this) {
        0 -> FlightTicket.PassengerAge.CHILD
        1 -> FlightTicket.PassengerAge.ADULT
        else -> throw IllegalStateException(Resources.getSystem().getString(R.string.wrong_parameter_age))
    }
}

fun Int.getValuePassengerAge(): Int{
    return when(this) {
        0 -> R.string.child
        1 -> R.string.adult
        else -> throw IllegalStateException(
            Resources.getSystem().getString(R.string.wrong_parameter_age)
        )
    }
}