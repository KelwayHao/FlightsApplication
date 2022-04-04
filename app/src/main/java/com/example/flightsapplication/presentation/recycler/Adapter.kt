package com.example.flightsapplication.presentation.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.listeners.DeleteOnClickListener

class Adapter(private val deleteOnClickListener: DeleteOnClickListener) : RecyclerView.Adapter<FlightViewHolder>() {

    private var items: List<FlightTicket> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        return FlightViewHolder.newInstance(parent, deleteOnClickListener)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(listItem: List<FlightTicket>) {
        items = listItem
        notifyDataSetChanged()
    }
}