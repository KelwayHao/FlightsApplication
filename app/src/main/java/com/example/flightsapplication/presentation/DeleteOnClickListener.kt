package com.example.flightsapplication.presentation

import com.example.flightsapplication.domain.models.FlightTicket

interface DeleteOnClickListener {
    fun deleteTicket(flightTicket: FlightTicket)
}