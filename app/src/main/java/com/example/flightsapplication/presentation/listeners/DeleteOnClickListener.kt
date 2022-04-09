package com.example.flightsapplication.presentation.listeners

import com.example.flightsapplication.domain.models.FlightTicket

interface DeleteOnClickListener {
    fun deleteTicket(flightTicket: FlightTicket)
}