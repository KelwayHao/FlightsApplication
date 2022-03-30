package com.example.flightsapplication.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity

@Dao
interface FlightTicketsDao {

    @Insert
    suspend fun saveFlightTicket(flightTicket: FlightTicketEntity)

    /*@Delete
    suspend fun deleteFlightTicket()*/

    @Query("SELECT * FROM flightTicketsTable")
    suspend fun getAllFlightTicket(): List<FlightTicketEntity>
}