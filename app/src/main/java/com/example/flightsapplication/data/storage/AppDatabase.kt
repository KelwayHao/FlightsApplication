package com.example.flightsapplication.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity
import com.example.flightsapplication.utils.Constant

@Database(entities = [FlightTicketEntity::class], version = Constant.VERSION_DB)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFlightTickets(): FlightTicketsDao
}