package com.example.flightsapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import com.example.flightsapplication.presentation.listeners.ValidationListener
import kotlinx.coroutines.launch
import java.util.*

class RegistrationFlightFragmentViewModel(private val interactor: FlightTicketInteractor) :
    ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    fun createFlightTicket(
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String,
        passengerAge: FlightTicket.PassengerAge,
        validListener: ValidationListener
    ) {
        viewModelScope.launch {
            if (isValid(
                    departure,
                    destination,
                    departDate,
                    returnDate,
                    numberPassportPassenger,
                    namePassenger,
                )
            ) {
                interactor.createFlightTickets(
                    departure,
                    destination,
                    departDate,
                    returnDate,
                    numberPassportPassenger,
                    namePassenger,
                    passengerAge
                )
                validListener.validationListener(R.string.message_flight_success)
            } else {
                validListener.validationListener(R.string.show_snack_validation)
            }
        }
    }

    fun getFlightTickets() {
        viewModelScope.launch {
            _flightTicket.postValue(interactor.getFlightTickets())
        }
    }

    private fun isValid(
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String
    ): Boolean {
        return !(departure.isEmpty() ||
                destination.isEmpty() ||
                departDate.isEmpty() ||
                returnDate.isEmpty() ||
                numberPassportPassenger.isEmpty() ||
                namePassenger.isEmpty())
    }
}
