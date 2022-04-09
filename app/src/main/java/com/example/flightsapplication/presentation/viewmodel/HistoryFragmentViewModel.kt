package com.example.flightsapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import kotlinx.coroutines.launch

class HistoryFragmentViewModel(private val interactor: FlightTicketInteractor) : ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    private val _snack = MutableLiveData<Int>()
    val snack: LiveData<Int> get() = _snack

    fun getFlightTickets() {
        viewModelScope.launch {
            _flightTicket.postValue(interactor.getFlightTickets())
        }
    }

    fun deleteFlightTicket(flightTicket: FlightTicket) {
        viewModelScope.launch {
            interactor.deleteFlightTickets(flightTicket)
        }.invokeOnCompletion {
            getFlightTickets()
            _snack.value = R.string.remote_success
        }
    }

    fun removeItem(position: Int) : FlightTicket? {
        return _flightTicket.value?.toMutableList()?.removeAt(position)
    }
}