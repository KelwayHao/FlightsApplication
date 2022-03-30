package com.example.flightsapplication.domain.repository

import com.example.flightsapplication.domain.models.FlightTicket
import java.util.*

interface FlightTicketInteractor {
    suspend fun getFlightTickets(): List<FlightTicket>

    suspend fun deleteFlightTickets()

    suspend fun createFlightTickets(
        departure: String,
        destination: String,
        departDate: Date,
        returnDate: Date,
        numberPassportPassenger: String,
        namePassenger: String,
        typePassenger: FlightTicket.TypePassenger
    )
}