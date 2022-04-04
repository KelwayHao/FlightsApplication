package com.example.flightsapplication.domain.repository

import com.example.flightsapplication.domain.models.FlightTicket

interface FlightTicketInteractor {
    suspend fun getFlightTickets(): List<FlightTicket>

    suspend fun deleteFlightTickets(flightTicket: FlightTicket)

    suspend fun createFlightTickets(
        id: Long,
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String,
        passengerAge: FlightTicket.PassengerAge
    )
}