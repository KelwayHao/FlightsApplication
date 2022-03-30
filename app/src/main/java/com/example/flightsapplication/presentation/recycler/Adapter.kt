package com.example.flightsapplication.presentation.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flightsapplication.domain.models.FlightTicket

class Adapter: RecyclerView.Adapter<FlightViewHolder>() {

    private var items: List<FlightTicket> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        return FlightViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(listItem: List<FlightTicket>){
        items = listItem
        notifyDataSetChanged()
    }
}