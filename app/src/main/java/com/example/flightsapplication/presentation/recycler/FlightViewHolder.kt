package com.example.flightsapplication.presentation.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flightsapplication.databinding.ItemFlightHistoryBinding
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.utils.getValuePassengerAge

class FlightViewHolder(private val binding: ItemFlightHistoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup) = FlightViewHolder(
            ItemFlightHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun bindItem(flightTicket: FlightTicket) {
        with(flightTicket) {
            binding.historyDeparture.text = departure
            binding.historyDestination.text = destination
            binding.historyDateDepart.text = departDate
            binding.historyDateArrival.text = returnDate
            binding.historyNumberPassportPassenger.text = numberPassportPassenger
            binding.historyNamePassenger.text = namePassenger
            binding.historyPassengerAge.text = binding.root.context.getString(passengerAge.idAge.getValuePassengerAge())
        }
    }
}