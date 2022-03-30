package com.example.flightsapplication.utils

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity
import com.example.flightsapplication.domain.models.FlightTicket
import java.text.SimpleDateFormat
import java.util.*

fun FragmentActivity.openFragment(idFrameFragment: Int, fragment: Fragment, tag: String) {
    supportFragmentManager
        .beginTransaction()
        .replace(idFrameFragment, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun FlightTicketEntity.toFlightTicket() =
    FlightTicket(
        departure = departure,
        destination = destination,
        departDate = departDate.fromStringToDate(),
        returnDate = returnDate.fromStringToDate(),
        numberPassportPassenger = numberPassportPassenger,
        namePassenger = namePassenger,
        typePassenger = typePassenger.toTypePassenger()
    )


fun FlightTicket.toFlightTicketEntity() =
    FlightTicketEntity(
        departure = departure,
        destination = destination,
        departDate = departDate.toString(),
        returnDate = returnDate.toString(),
        numberPassportPassenger = numberPassportPassenger,
        namePassenger = namePassenger,
        typePassenger = typePassenger.type
    )


@SuppressLint("SimpleDateFormat")
fun String.fromStringToDate(): Date {
    val formatter = SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH)
    val date: Date? = formatter.parse(this)
    return date ?: throw IllegalStateException("Wrong format!")
    //return formatter.format(date)
}

fun String.toTypePassenger(): FlightTicket.TypePassenger {
    return FlightTicket.TypePassenger.valueOf(this.uppercase())
}
