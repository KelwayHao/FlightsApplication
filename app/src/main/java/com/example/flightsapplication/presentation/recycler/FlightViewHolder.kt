package com.example.flightsapplication.presentation.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flightsapplication.R
import com.example.flightsapplication.databinding.ItemFlightHistoryBinding
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.utils.getValuePassengerAge

class FlightViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val binding by viewBinding<ItemFlightHistoryBinding>()

    companion object {
        fun newInstance(parent: ViewGroup) =
            FlightViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_flight_history, parent, false)
            )
    }

    @SuppressLint("SetTextI18n")
    fun bindItem(flightTicket: FlightTicket) {
        with(binding) {
            with(itemView) {
                with(flightTicket) {
                    historyDeparture.text = departure
                    historyDestination.text = destination
                    historyDateDepart.text = departDate
                    historyDateArrival.text = returnDate
                    historyNumberPassportPassenger.text = numberPassportPassenger
                    historyNamePassenger.text = namePassenger
                    historyPassengerAge.text =
                        context.getString(passengerAge.idAge.getValuePassengerAge())
                }
            }
        }
    }
}