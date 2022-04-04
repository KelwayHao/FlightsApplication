package com.example.flightsapplication.domain.models

data class FlightTicket(
    val id: Long,
    val departure: String,
    val destination: String,
    val departDate: String,
    val returnDate: String,
    val numberPassportPassenger: String,
    val namePassenger: String,
    val passengerAge: PassengerAge

) {
    enum class PassengerAge(val type: String) {
        ADULT("Adult"),
        CHILD("Child")
    }
}

