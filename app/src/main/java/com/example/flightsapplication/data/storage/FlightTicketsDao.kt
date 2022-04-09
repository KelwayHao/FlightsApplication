package com.example.flightsapplication.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity
import com.example.flightsapplication.domain.models.FlightTicket

@Dao
interface FlightTicketsDao {

    @Insert
    suspend fun saveFlightTicket(flightTicket: FlightTicketEntity)

    @Delete
    suspend fun deleteFlightTicket(flightTicket: FlightTicketEntity)

    @Query("SELECT * FROM flighttickets")
    suspend fun getAllFlightTicket(): List<FlightTicketEntity>
}