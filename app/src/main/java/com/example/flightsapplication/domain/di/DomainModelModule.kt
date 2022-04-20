package com.example.flightsapplication.domain.di

import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import com.example.flightsapplication.domain.repository.FlightTicketRepository
import com.example.flightsapplication.domain.repository.FlightTicketRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModelModule {

    @Provides
    fun provideFlightTicketRepositoryImpl(
        repository: FlightTicketRepository
    ): FlightTicketInteractor {
        return FlightTicketRepositoryImpl(repository)
    }
}