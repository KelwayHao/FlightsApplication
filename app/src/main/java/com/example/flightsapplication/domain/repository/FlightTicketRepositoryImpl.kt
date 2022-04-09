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
                departure = departure,
                destination = destination,
                departDate = departDate,
                returnDate = returnDate,
                numberPassportPassenger = numberPassportPassenger,
                namePassenger = namePassenger,
                passengerAge = passengerAge
            )
        )
    }

}