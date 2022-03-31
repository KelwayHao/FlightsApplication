package com.example.flightsapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import kotlinx.coroutines.launch

class HistoryFragmentViewModel(private val interactor: FlightTicketInteractor) : ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    fun getFlightTickets() {
        viewModelScope.launch {
            _flightTicket.postValue(interactor.getFlightTickets())
        }
    }

    fun deleteFlightTicket(flightTicket: FlightTicket) {
        viewModelScope.launch {
            interactor.deleteFlightTickets(flightTicket)
            getFlightTickets()
        }
    }
}