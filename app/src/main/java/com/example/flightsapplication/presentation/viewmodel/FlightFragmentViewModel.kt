package com.example.flightsapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import com.example.flightsapplication.utils.checkValidPassport
import kotlinx.coroutines.launch

class FlightFragmentViewModel(private val interactor: FlightTicketInteractor) :
    ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    private val _snack = MutableLiveData<Int>()
    val snack: LiveData<Int> get() = _snack

    init {
        getFlightTickets()
    }

    fun createFlightTicket(
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String,
        passengerAge: FlightTicket.PassengerAge,
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
                    departure = departure,
                    destination = destination,
                    departDate = departDate,
                    returnDate = returnDate,
                    numberPassportPassenger = numberPassportPassenger,
                    namePassenger = namePassenger,
                    passengerAge = passengerAge
                )
                _snack.value = R.string.message_flight_success
            } else {
                _snack.value = R.string.show_snack_validation
            }
        }
    }

    private fun getFlightTickets() {
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
        return (departure.isNotEmpty() &&
                destination.isNotEmpty() &&
                departDate.isNotEmpty() &&
                returnDate.isNotEmpty() &&
                numberPassportPassenger.checkValidPassport() &&
                namePassenger.isNotEmpty())
    }
}
