package com.example.flightsapplication.domain.repository

import com.example.flightsapplication.domain.models.FlightTicket
import java.util.*

class FlightTicketRepositoryImpl(private val repository: FlightTicketRepository) :
    FlightTicketInteractor {
    override suspend fun getFlightTickets(): List<FlightTicket> {
        return repository.getSavedFlightTicket()
    }

    override suspend fun deleteFlightTickets(flightTicket: FlightTicket) {
        repository.deleteFlightTicketOnDatabase(flightTicket)
    }

    override suspend fun createFlightTickets(
        id:Long,
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String,
        passengerAge: FlightTicket.PassengerAge
    ) {
        repository.saveFlightTicket(
            FlightTicket(
                id,
                departure,
                destination,
                departDate,
                returnDate,
                numberPassportPassenger,
                namePassenger,
                passengerAge
            )
        )
    }

}