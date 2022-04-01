package com.example.flightsapplication.domain.models

import java.util.*

data class FlightTicket(
    val departure: String,
    val destination: String,
    val departDate: String,
    val returnDate: String,
    val numberPassportPassenger: String,
    val namePassenger: String,
    val typePassenger: TypePassenger

) {
    enum class TypePassenger(val type: String) {
        ADULT("Adult"),
        CHILD("Child")
    }
}

