package com.example.flightsapplication.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import kotlinx.android.synthetic.main.item_flight_history.view.*

class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(parent: ViewGroup) = FlightViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_flight_history, parent, false)
        )
    }

    fun bindItem(flightTicket: FlightTicket) {
        with(flightTicket) {
            itemView.historyDeparture.text = departure
            itemView.historyDestination.text = destination
            itemView.historyDateDepart.text = departDate
            itemView.historyDateReturn.text = returnDate
            itemView.historyNumberPassportPassenger.text = numberPassportPassenger
            itemView.historyNamePassenger.text = namePassenger
            itemView.historyTypePassenger.text = passengerAge.type
        }
    }
}