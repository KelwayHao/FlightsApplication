package com.example.flightsapplication.data.di

import com.example.flightsapplication.data.repository.FlightTicketEntityRepositoryImpl
import com.example.flightsapplication.domain.repository.FlightTicketRepository
import org.koin.dsl.module

val dataModule = module {
    single<FlightTicketRepository> {
        FlightTicketEntityRepositoryImpl(get())
    }
}