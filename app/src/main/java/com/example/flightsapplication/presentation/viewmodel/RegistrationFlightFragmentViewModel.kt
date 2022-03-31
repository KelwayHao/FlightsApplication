package com.example.flightsapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import kotlinx.coroutines.launch
import java.util.*

class RegistrationFlightFragmentViewModel(private val interactor: FlightTicketInteractor) :
    ViewModel() {

    private val _submitFlightTicket = MutableLiveData<List<FlightTicket>>()
    val submitFlightTicket: LiveData<List<FlightTicket>> get() = _submitFlightTicket

    fun createFlightTicket(
        id: Long,
        departure: String,
        destination: String,
        departDate: Date,
        returnDate: Date,
        numberPassportPassenger: String,
        namePassenger: String,
        typePassenger: FlightTicket.TypePassenger
    ) {
        viewModelScope.launch {
            interactor.createFlightTickets(
                id,
                departure,
                destination,
                departDate,
                returnDate,
                numberPassportPassenger,
                namePassenger,
                typePassenger
            )
        }
    }
}
