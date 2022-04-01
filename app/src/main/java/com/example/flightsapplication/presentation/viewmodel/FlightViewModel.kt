package com.example.flightsapplication.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import com.example.flightsapplication.utils.showSnack
import kotlinx.coroutines.launch

class FlightViewModel(private val interactor: FlightTicketInteractor) : ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    fun createFlightTicket(
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String,
        typePassenger: FlightTicket.TypePassenger,
        view: View
    ) {
        viewModelScope.launch {
            if (validation(
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
                    typePassenger
                )
                showSnack(view.context.getString(R.string.message_flight_success), view)
            } else {
                showSnack(view.context.getString(R.string.show_snack_validation), view)
            }
        }
    }

    fun getFlightTickets() {
        viewModelScope.launch {
            _flightTicket.postValue(interactor.getFlightTickets())
        }
    }

    private fun validation(
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
