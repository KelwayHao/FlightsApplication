package com.example.flightsapplication.data.repository

import com.example.flightsapplication.data.storage.FlightTicketsDao
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketRepository
import com.example.flightsapplication.utils.toFlightTicket
import com.example.flightsapplication.utils.toFlightTicketEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FlightTicketEntityRepositoryImpl(private val flightTicketsDao: FlightTicketsDao) :
    FlightTicketRepository {
    override suspend fun getSavedFlightTicket(): List<FlightTicket> {
        return withContext(Dispatchers.IO) {
            flightTicketsDao.getAllFlightTicket()
                .map { flightTicketEntity -> flightTicketEntity.toFlightTicket() }
        }
    }

    override suspend fun saveFlightTicket(ticket: FlightTicket) {
        return withContext(Dispatchers.IO) {
            flightTicketsDao.saveFlightTicket(ticket.toFlightTicketEntity())
        }
    }

    /*override suspend fun deleteFlightTicketOnDatabase() {
        TODO("Not yet implemented")
    }*/
}