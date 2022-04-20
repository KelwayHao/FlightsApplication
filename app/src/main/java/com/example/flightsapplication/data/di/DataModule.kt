package com.example.flightsapplication.data.di

import com.example.flightsapplication.data.repository.FlightTicketEntityRepositoryImpl
import com.example.flightsapplication.data.storage.FlightTicketsDao
import com.example.flightsapplication.domain.repository.FlightTicketRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideFlightTicketEntityRepositoryImpl(
        flightTicketsDao: FlightTicketsDao
    ): FlightTicketRepository {
        return FlightTicketEntityRepositoryImpl(flightTicketsDao)
    }
}