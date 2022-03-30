package com.example.flightsapplication.domain.repository

import com.example.flightsapplication.domain.models.FlightTicket

interface FlightTicketRepository {

    suspend fun getSavedFlightTicket(): List<FlightTicket>

    suspend fun saveFlightTicket(ticket: FlightTicket)

    suspend fun deleteFlightTicketOnDatabase()
}