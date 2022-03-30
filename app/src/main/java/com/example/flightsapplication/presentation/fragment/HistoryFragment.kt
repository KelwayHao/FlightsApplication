package com.example.flightsapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.flightsapplication.R
import com.example.flightsapplication.presentation.recycler.Adapter
import com.example.flightsapplication.presentation.viewmodel.FlightViewModel
import kotlinx.android.synthetic.main.fragment_flight_history.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HistoryFragment: Fragment(R.layout.fragment_flight_history){

    private val viewModel:FlightViewModel by sharedViewModel()
    private val adapter by lazy { Adapter() }

    companion object {
        const val TAG = "History fragment"
        fun newInstance() = HistoryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFlightTickets()

        recyclerFlights.adapter = adapter

        viewModel.flightTicket.observe(viewLifecycleOwner) { listFlightTicket ->
            adapter.submitItem(listFlightTicket)
        }
    }

}