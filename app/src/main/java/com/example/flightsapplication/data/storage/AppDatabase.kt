package com.example.flightsapplication.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity

@Database(entities = [FlightTicketEntity::class], version = AppDatabase.VERSION_DB)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val VERSION_DB = 1
    }

    abstract fun getFlightTickets(): FlightTicketsDao
}