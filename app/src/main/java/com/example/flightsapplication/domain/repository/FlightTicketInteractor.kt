package com.example.flightsapplication.domain.repository

import com.example.flightsapplication.domain.models.FlightTicket

interface FlightTicketInteractor {
    suspend fun getFlightTickets(): List<FlightTicket>

    suspend fun createFlightTickets(
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String,
        typePassenger: FlightTicket.PassengerAge
    )
}