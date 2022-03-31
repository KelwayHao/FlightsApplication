package com.example.flightsapplication.domain.repository

import com.example.flightsapplication.domain.models.FlightTicket
import java.util.*

interface FlightTicketInteractor {
    suspend fun getFlightTickets(): List<FlightTicket>

    suspend fun deleteFlightTickets(flightTicket: FlightTicket)

    suspend fun createFlightTickets(
        id: Long,
        departure: String,
        destination: String,
        departDate: Date,
        returnDate: Date,
        numberPassportPassenger: String,
        namePassenger: String,
        typePassenger: FlightTicket.TypePassenger
    )
}