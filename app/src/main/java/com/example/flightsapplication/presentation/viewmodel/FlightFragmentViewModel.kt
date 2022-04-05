package com.example.flightsapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import kotlinx.coroutines.launch

class FlightFragmentViewModel(private val interactor: FlightTicketInteractor) :
    ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    private val _snack = MutableLiveData<Int>()
    val snack: LiveData<Int> get() = _snack

    fun createFlightTicket(
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String,
        passengerAge: FlightTicket.PassengerAge,
    ) {
        getFlightTickets()
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
                    getSize(),
                    departure,
                    destination,
                    departDate,
                    returnDate,
                    numberPassportPassenger,
                    namePassenger,
                    passengerAge
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

    private fun getSize(): Long {
        return flightTicket.value?.size?.toLong() ?: 0
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
                numberPassportPassenger.isNotEmpty() &&
                namePassenger.isNotEmpty())
    }
}
