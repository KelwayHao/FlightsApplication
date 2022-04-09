package com.example.flightsapplication.domain.models

data class FlightTicket(
    var id: Long = 0,
    val departure: String,
    val destination: String,
    val departDate: String,
    val returnDate: String,
    val numberPassportPassenger: String,
    val namePassenger: String,
    val passengerAge: PassengerAge
) {
    init {
        id = departDate.hashCode() + returnDate.hashCode().toLong()
    }
    enum class PassengerAge(val idAge: Int) {
        CHILD(0),
        ADULT(1)
    }
}

