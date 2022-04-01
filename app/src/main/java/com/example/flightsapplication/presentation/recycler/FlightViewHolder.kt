package com.example.flightsapplication.presentation.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.DeleteOnClickListener
import com.example.flightsapplication.utils.fromDateToString
import kotlinx.android.synthetic.main.item_flight_history.view.*

class FlightViewHolder(itemView: View, private val deleteOnClickListener: DeleteOnClickListener) :
    RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(parent: ViewGroup, deleteOnClickListener: DeleteOnClickListener) =
            FlightViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_flight_history, parent, false), deleteOnClickListener
            )
    }

    @SuppressLint("SetTextI18n")
    fun bindItem(flightTicket: FlightTicket) {
        with(flightTicket) {
            itemView.historyDeparture.text = departure
            itemView.historyDestination.text = destination
            itemView.historyDateDepart.text = departDate.fromDateToString()
            itemView.historyDateArrival.text = returnDate.fromDateToString()
            itemView.historyNumberPassportPassenger.text = numberPassportPassenger
            itemView.historyNamePassenger.text = namePassenger
            itemView.historyTypePassenger.text = typePassenger.type
        }

        itemView.imageDeleteObject.setOnClickListener {
            deleteOnClickListener.deleteTicket(flightTicket)
        }
    }
}