package com.example.flightsapplication.domain.di

import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import com.example.flightsapplication.domain.repository.FlightTicketRepositoryImpl
import org.koin.dsl.module

val domainModelModule = module {

    single<FlightTicketInteractor> {
        FlightTicketRepositoryImpl(get())
    }

}