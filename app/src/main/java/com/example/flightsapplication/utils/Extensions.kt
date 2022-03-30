package com.example.flightsapplication.utils

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity
import com.example.flightsapplication.domain.models.FlightTicket
import com.google.android.material.snackbar.Snackbar
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
        departDate = departDate.fromDateToString(),
        returnDate = returnDate.fromDateToString(),
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

fun showSnack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}


