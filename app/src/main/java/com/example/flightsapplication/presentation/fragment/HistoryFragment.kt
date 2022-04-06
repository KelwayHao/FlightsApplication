package com.example.flightsapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.listeners.DeleteOnClickListener
import com.example.flightsapplication.presentation.recycler.Adapter
import com.example.flightsapplication.presentation.viewmodel.HistoryFragmentViewModel
import com.example.flightsapplication.utils.dialog
import com.example.flightsapplication.utils.showSnack
import kotlinx.android.synthetic.main.fragment_flight_history.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment(R.layout.fragment_flight_history) {

    private val viewTicketModel by viewModel<HistoryFragmentViewModel>()
    private val adapter by lazy { Adapter(deleteClickListener) }

    companion object {
        const val TAG = "History fragment"
        fun newInstance() = HistoryFragment()
    }

    private val deleteClickListener by lazy {
        object : DeleteOnClickListener {
            override fun deleteTicket(flightTicket: FlightTicket) {
                dialog(getString(R.string.title_dialog_message), requireActivity()) {
                    viewTicketModel.deleteFlightTicket(flightTicket)
                }
            }
            init {
                viewTicketModel.snack.observe(viewLifecycleOwner) { event ->
                    showSnack(requireActivity().getString(event), requireView())
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewTicketModel.getFlightTickets()
        initObserver()
    }

    private fun initObserver() {
        recyclerFlights.adapter = adapter

        viewTicketModel.flightTicket.observe(viewLifecycleOwner) { listTicket ->
            adapter.submitItem(listTicket)
        }
    }
}