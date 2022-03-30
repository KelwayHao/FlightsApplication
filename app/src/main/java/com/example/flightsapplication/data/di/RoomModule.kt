package com.example.flightsapplication.data.di

import androidx.room.Room
import com.example.flightsapplication.data.storage.AppDatabase
import com.example.flightsapplication.data.storage.FlightTicketsDao
import org.koin.dsl.module

val roomModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "flightTicketsTable"
        ).build()
    }

    single<FlightTicketsDao> {
        get<AppDatabase>().getFlightTickets()
    }
}