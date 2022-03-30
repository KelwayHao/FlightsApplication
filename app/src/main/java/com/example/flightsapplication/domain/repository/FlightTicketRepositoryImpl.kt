package com.example.flightsapplication.domain.repository

import com.example.flightsapplication.domain.models.FlightTicket
import java.util.*

class FlightTicketRepositoryImpl(private val repository: FlightTicketRepository): FlightTicketInteractor {
    override suspend fun getFlightTickets(): List<FlightTicket> {
        return repository.getSavedFlightTicket()
    }

    /*override suspend fun deleteFlightTickets() {
        TODO("Not yet implemented")
    }*/

    override suspend fun createFlightTickets(
        departure: String,
        destination: String,
        departDate: Date,
        returnDate: Date,
        numberPassportPassenger: String,
        namePassenger: String,
        typePassenger: FlightTicket.TypePassenger
    ) {
        repository.saveFlightTicket(
            FlightTicket(
                departure,
                destination,
                departDate,
                returnDate,
                numberPassportPassenger,
                namePassenger,
                typePassenger
            )
        )
    }

}